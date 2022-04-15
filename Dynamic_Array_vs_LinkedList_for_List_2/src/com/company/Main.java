package com.company;

abstract class Test
{
    static int max = 100_000;
    static int[] randIndex;

    static{
        randIndex = new int[max/2];
        for (int i=0; i<randIndex.length; i++)
            randIndex[i] = (int)(Math.random() * (max/2+i));
    }

    abstract void pushBack();
    abstract void insert();
    abstract void find();
    abstract void print();

    public void run()
    {
        final long start = System.currentTimeMillis();

        final long start_pushBack = System.currentTimeMillis();
        this.pushBack();
        final long end_pushBack = System.currentTimeMillis();
//        this.print();

        final long start_insert = System.currentTimeMillis();
        this.insert();
        final long end_insert = System.currentTimeMillis();
//        this.print();

        final long start_find = System.currentTimeMillis();
        this.find();
        final long end_find = System.currentTimeMillis();

        final long end = System.currentTimeMillis();

        System.out.println("pushBack : "+ (end_pushBack - start_pushBack)/1000.0);
        System.out.println("insert : "+ (end_insert - start_insert)/1000.0);
        System.out.println("find : "+ (end_find - start_find)/1000.0);
        System.out.println("total : "+ (end - start)/1000.0);
    }
}

public class Main {

    public static void main(String[] args) {
//        FirstDynamicArrayTest arrTest = new FirstDynamicArrayTest();
//        arrTest.run();
//        System.out.println();
//        SecondLinkedListTest linkTest = new SecondLinkedListTest();
//        linkTest.run();

//        IssueTest issueTest = new IssueTest();
//        issueTest.main();

        ChangedTest changedTest = new ChangedTest();
        changedTest.main();
    }
}
