package com.company;

class FirstNode
{
    int val;
    FirstNode next;

    FirstNode(int val)
    {
        this.val = val;
        this.next = null;
    }

    void setNext(FirstNode node)
    {
        this.next = node;
    }

    FirstNode popNode()
    {
        return next;
    }
}

public class FirstLinkedListTest extends Test
{
    FirstNode head = new FirstNode(0);
    FirstNode rear = head;

    FirstLinkedListTest()
    {
        System.out.println("[LinkedListTest]");
    }

    @Override
    void pushBack()
    {
        for(int i=1; i<max/2; i++)
        {
            FirstNode nw = new FirstNode(i);
            rear.setNext(nw);
            rear=nw;
        }
    }

    @Override
    void insert()
    {
        for(int idx : randIndex)
        {
            FirstNode nw = new FirstNode(idx);
            if (idx == 0)
            {
                nw.setNext(head);
                head = nw;
            }
            else
            {
                FirstNode crnt = this.head;
                for(int i=0; i<idx-1; i++)
                {
                    crnt = crnt.next;
                }

                nw.setNext(crnt.next);
                crnt.setNext(nw);
            }
        }
    }

    @Override
    void find()
    {
        for(int idx : randIndex)
        {
            FirstNode crnt = this.head;
            for(int i=0; i<idx; i++)
            {
                crnt = crnt.next;
            }
        }
    }

    @Override
    void print(){
        FirstNode crnt = this.head;
        while (crnt != null){
            System.out.print(crnt.val + " ");
            crnt = crnt.next;
        }
        System.out.println();
    }
}