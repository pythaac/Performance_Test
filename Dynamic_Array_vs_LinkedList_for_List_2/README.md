### 동기
[Dynamic Array vs LinkedList for List 테스트](https://github.com/pythaac/Performance_Test/tree/main/Dynamic_Array_vs_LinkedList_for_List)에서 LinkedList에 비해 Dynamic Array의 
삽입이 빠른 것을 확인했습니다. 그런데 [Java의 정석 코드](https://github.com/pythaac/Performance_Test/blob/main/Dynamic_Array_vs_LinkedList_for_List_2/src/com/company/IssueTest.java)에 따르면 비슷하게 동작하는 Java의 **Collection.ArrayList와 Collection.LinkedList에서는 LinkedList의 insert가 훨씬 빠르다고 합니다.**  
![second](./image/second.PNG)  
삽입에 사용하는 [LinkedList의 add()](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html#add(int,%20E))를 보면 다음과 같이 구현되어 있으며,
이를 통해 __탐색이 최대 N/2만큼 진행되는 것__ 외에는 위 테스트 insert 과정이 비슷해보입니다. (왜 O(1)인지 알아볼 필요가 있습니다.)  

```java
// LinkedList::add
public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
```  
```java
// LinkedList::node
Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```  
&nbsp;  

### Description (2nd TEST)
우선 확인된 내용을 확인하기 위해, SecondLinkedListTest에는 doubly linkedlist로 변경하여, index가 head와 rear중 더 가까운 곳부터 탐색하도록 수정하였습니다.  

2. LinkedList  
- insert : Node를 생성하여 head와 rear중 인덱스가 더 가까운 곳에서 탐색하고, 인덱스의 노드 <-> 생성 Node <-> 인덱스의 노드.next로 설정합니다.
- find : head와 rear중 해당 인덱스와 가까운 곳부터 순차탐색합니다.  
&nbsp;  

### Conclusion (2nd TEST)
_max_ 가 100_000일 때, 결과는 다음과 같습니다:  
![capture](./image/second.PNG)  

아쉽지만 차이점이 보이지 않습니다. Collection.LinkedList의 빠른 삽입 속도는 2nd TEST에서 추가한 내용이 핵심이 아닙니다.
&nbsp;  
