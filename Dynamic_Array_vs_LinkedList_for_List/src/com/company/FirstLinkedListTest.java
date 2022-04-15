package com.company;

public class FirstLinkedListTest extends Test
{
    Node head = new Node(0);
    Node rear = head;

    FirstLinkedListTest()
    {
        System.out.println("[LinkedListTest]");
    }

    @Override
    void pushBack()
    {
        for(int i=1; i<max/2; i++)
        {
            Node nw = new Node(i);
            rear.setNext(nw);
            rear=nw;
        }
    }

    @Override
    void insert()
    {
        for(int idx : randIndex)
        {
            Node nw = new Node(idx);
            if (idx == 0)
            {
                nw.setNext(head);
                head = nw;
            }
            else
            {
                Node crnt = this.head;
                for(int i=0; i<idx-1; i++)
                {
                    crnt = crnt.next;
                }

                nw.setNext(crnt.next);
                crnt.next = nw;
            }
        }
    }

    @Override
    void find()
    {
        for(int idx : randIndex)
        {
            Node crnt = this.head;
            for(int i=0; i<idx; i++)
            {
                crnt = crnt.next;
            }
        }
    }

    @Override
    void print(){
        Node crnt = this.head;
        while (crnt != null){
            System.out.print(crnt.val + " ");
            crnt = crnt.next;
        }
        System.out.println();
    }
}