package com.company;

class SecondNode
{
    int val;
    SecondNode next;
    SecondNode before;

    SecondNode(int val)
    {
        this.val = val;
        this.next = null;
        this.before = null;
    }

    void setNext(SecondNode node)
    {
        this.next = node;
    }

    void setBefore(SecondNode node)
    {
        this.before = node;
    }

    SecondNode popNode()
    {
        return next;
    }
}

public class SecondLinkedListTest extends Test
{
    SecondNode head = new SecondNode(0);
    SecondNode rear = head;
    int len = 0;

    SecondLinkedListTest()
    {
        System.out.println("[LinkedListTest]");
    }

    @Override
    void pushBack()
    {
        for(int i=1; i<max/2; i++)
        {
            SecondNode nw = new SecondNode(i);
            rear.setNext(nw);
            nw.setBefore(rear);
            rear=nw;
            len++;
        }
    }

    @Override
    void insert()
    {
        for(int idx : randIndex)
        {
            SecondNode nw = new SecondNode(idx);
            if (idx == 0)
            {
                nw.setNext(head);
                head.setBefore(nw);
                head = nw;
            }
            else if (idx == len)
            {
                rear.setNext(nw);
                nw.setBefore(rear);
                rear=nw;
            }
            else if (idx < len >> 1)
            {
                SecondNode crnt = head;
                for(int i=0; i<idx; i++)
                {
                    crnt = crnt.next;
                }

                crnt.before.setNext(nw);
                nw.setBefore(crnt.before);
                crnt.setBefore(nw);
                nw.setNext(crnt);
            }
            else
            {
                SecondNode crnt = rear;
                for(int i=len-1; i>idx; i--)
                {
                    crnt = crnt.before;
                }

                crnt.before.setNext(nw);
                nw.setBefore(crnt.before);
                crnt.setBefore(nw);
                nw.setNext(crnt);
            }
            len++;
        }
    }

    @Override
    void find()
    {
        for(int idx : randIndex)
        {
            if (idx < len >> 1)
            {
                SecondNode crnt = head;
                for(int i=0; i<idx; i++)
                {
                    crnt = crnt.next;
                }
            }
            else
            {
                SecondNode crnt = rear;
                for(int i=len-1; i>idx; i--)
                {
                    crnt = crnt.before;
                }
            }
        }
    }

    @Override
    void print(){
        SecondNode crnt = this.head;
        while (crnt != null){
            System.out.print(crnt.val + " ");
            crnt = crnt.next;
        }
        System.out.println();
    }
}