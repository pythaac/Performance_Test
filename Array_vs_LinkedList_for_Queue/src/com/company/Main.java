package com.company;

class Node
{
    int val;
    Node next;

    Node(int val)
    {
        this.val = val;
    }

    void setNext(Node node)
    {
        this.next = node;
    }

    Node popNode()
    {
        return next;
    }
}

class LinkedListTest
{
    final int max;
    Node head = new Node(0);

    LinkedListTest(int max)
    {
        this.max = max;
    }

    public void run()
    {
        Node crnt = this.head;
        long start = System.currentTimeMillis();

        for(int i=1; i<this.max; i++)
        {
            Node nw = new Node(i);
            crnt.setNext(nw);
            crnt=nw;
        }

        for(int i=0; i<this.max; i++)
        {
            this.head = this.head.popNode();
        }

        long end = System.currentTimeMillis();
        System.out.println("LinkedListTest : "+ (end - start)/1000.0);
    }
}

class ArrayTest
{
    final int max;
    int[] arr;

    ArrayTest(int max)
    {
        this.max = max;
        this.arr = new int[max];
    }

    public void run()
    {
        int head = 0, rear = 0;
        long start = System.currentTimeMillis();

        for(int i=0; i<this.max; i++)
        {
            this.arr[head++] = i;
        }

        for(int i=0; i<this.max; i++)
        {
            this.arr[rear++] = 0;
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayTest : "+ (end - start)/1000.0);
    }
}

public class Main {

    public static void main(String[] args) {
        final int max = 10_000_000;

        ArrayTest arrTest = new ArrayTest(max);
        arrTest.run();
        LinkedListTest linkTest = new LinkedListTest(max);
        linkTest.run();
    }
}
