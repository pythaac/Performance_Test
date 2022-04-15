package com.company;

class Node
{
    int val;
    Node before;

    Node(int val)
    {
        this.val = val;
        this.before = null;
    }

    void setBefore(Node node)
    {
        this.before = node;
    }

    Node popNode()
    {
        return before;
    }
}

abstract class Test
{
    final int max;

    Test(int max)
    {
        this.max = max;
    }

    abstract void push();
    abstract void pop();

    public void run(int num)
    {
        final long start = System.currentTimeMillis();

        final long start_push = System.currentTimeMillis();
        this.push();
        final long end_push = System.currentTimeMillis();

        final long start_pop = System.currentTimeMillis();
        this.pop();
        final long end_pop = System.currentTimeMillis();

        final long end = System.currentTimeMillis();

        System.out.println("push : "+ (end_push - start_push)/1000.0);
        System.out.println("pop : "+ (end_pop - start_pop)/1000.0);
        System.out.println("total : "+ (end - start)/1000.0);
    }
}

class LinkedListTest extends Test
{
    Node head = new Node(0);
    Node top = head;

    LinkedListTest(int max)
    {
        super(max);
        System.out.println("[LinkedListTest]");
    }

    @Override
    void push()
    {
        for(int i=1; i<max; i++)
        {
            Node nw = new Node(i);
            nw.setBefore(top);
            top=nw;
        }
    }

    @Override
    void pop()
    {
        for(int i=0; i<this.max; i++)
        {
//            System.out.print(top.val + " ");
            top = top.popNode();
        }
    }
}

class DynamicArrayTest extends Test
{
    int[] arr;
    int top = 0;

    DynamicArrayTest(int max)
    {
        super(max);
        this.arr = new int[2];
        System.out.println("[DynamicArrayTest]");
    }

    @Override
    void push()
    {
        for(int i=0; i<this.max; i++)
        {
            if (top == arr.length){
                int[] nw_arr = new int[arr.length * 2];
                System.arraycopy(arr, 0, nw_arr, 0, arr.length);
                arr = nw_arr;
            }
            arr[top++] = i;
        }
    }

    @Override
    void pop()
    {
        for(int i=0; i<max; i++)
        {
//            System.out.print(arr[top-1] + " ");
            top--;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        final int max = 1_000_000;

        DynamicArrayTest arrTest = new DynamicArrayTest(max);
        arrTest.run(max-1);
        System.out.println();
        LinkedListTest linkTest = new LinkedListTest(max);
        linkTest.run(max-1);
    }
}