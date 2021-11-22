package com.company;

class Node
{
    int val;
    Node next;

    Node(int val)
    {
        this.val = val;
        this.next = null;
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

abstract class Test
{
    final int max;

    Test(int max)
    {
        this.max = max;
    }

    abstract void enqueue();
    abstract void find(int num);
    abstract void dequeue();

    public void run(int num)
    {
        final long start = System.currentTimeMillis();

        final long start_enqueue = System.currentTimeMillis();
        this.enqueue();
        final long end_enqueue = System.currentTimeMillis();

        long start_find = System.currentTimeMillis();
        this.find(num);
        long end_find = System.currentTimeMillis();

        final long start_dequeue = System.currentTimeMillis();
        this.dequeue();
        final long end_dequeue = System.currentTimeMillis();

        final long end = System.currentTimeMillis();

        System.out.println("enqueue : "+ (end_enqueue - start_enqueue)/1000.0);
        System.out.println("find (" + num + ") : "+ (end_find - start_find)/1000.0);
        System.out.println("dequeue : "+ (end_dequeue - start_dequeue)/1000.0);
        System.out.println("total : "+ (end - start)/1000.0);
    }
}

class LinkedListTest extends Test
{
    Node head = new Node(0);

    LinkedListTest(int max)
    {
        super(max);
        System.out.println("[LinkedListTest]");
    }

    @Override
    void enqueue()
    {
        Node crnt = this.head;
        for(int i=1; i<this.max; i++)
        {
            Node nw = new Node(i);
            crnt.setNext(nw);
            crnt=nw;
        }
    }

    @Override
    void find(int num)
    {
        Node crnt = this.head;
        for(int i=0; i<this.max; i++)
        {
            if (crnt.val == num) break;
            crnt = crnt.next;
        }
    }

    @Override
    void dequeue()
    {
        for(int i=0; i<this.max; i++)
        {
            this.head = this.head.popNode();
        }
    }
}

class ArrayTest extends Test
{
    int[] arr;
    int head = 0, rear = 0;

    ArrayTest(int max)
    {
        super(max);
        this.arr = new int[max];
        System.out.println("[ArrayTest]");
    }

    @Override
    void enqueue()
    {
        for(int i=0; i<this.max; i++)
        {
            this.arr[this.head++] = i;
        }
    }

    @Override
    void find(int num)
    {
        for(int i=0; i<this.max; i++)
        {
            if (this.arr[i] == num) break;
        }
    }

    @Override
    void dequeue()
    {
        for(int i=0; i<this.max; i++)
        {
            this.arr[rear++] = 0;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        final int max = 10_000_000;

        ArrayTest arrTest = new ArrayTest(max);
        arrTest.run(max-1);
        System.out.println();
        LinkedListTest linkTest = new LinkedListTest(max);
        linkTest.run(max-1);
    }
}
