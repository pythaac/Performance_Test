# Dynamic Array vs LinkedList for Queue
Dynamic array를 이용한 Queue와 LinkedList를 이용한 Queue의 간단한 속도 측정 테스트입니다.

### Description
테스트는 enqueue, dequeue의 시간 측정입니다. _max_ 만큼 데이터를 enqueue하는 시간을 측정하고,
_max_ 만큼 데이터를 dequeue하는 시간을 측정합니다.  
1. Dynamic array  
- Enqueue : Array의 크기는 2로 시작하며, 크기가 꽉차면 2배씩 증가합니다.
- Dequeue : index 0를 pop하며, 나머지 데이터를 shift합니다.
2. LinkedList  
- Enqueue : Node를 생성하여 rear.next에 추가합니다.
- Dequeue : head를 head.next로 변경합니다.

### Conclusion
_max_ 가 200_000일 때, 결과는 다음과 같습니다:  
![capture](/image/capture.PNG)  

1. Enqueue  
- Dynamic Array가 더 빠릅니다.
- Array의 크기 증가로 인한 copy 오버헤드에도 불구하고, LinkedList의 동적 할당 시간이 더 소요되는 듯 합니다.
2. Dequeue  
- LinkedList가 월등히 빠릅니다.
- Array의 shift(O(n^2))로 인해 속도 차이가 크게 발생합니다.
