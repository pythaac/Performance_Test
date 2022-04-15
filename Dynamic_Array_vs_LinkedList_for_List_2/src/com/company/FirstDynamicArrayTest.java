package com.company;

public class FirstDynamicArrayTest extends Test
{
    int[] arr;
    int rear = 0;

    FirstDynamicArrayTest()
    {
        this.arr = new int[2];
        System.out.println("[DynamicArrayTest]");
    }

    @Override
    void pushBack()
    {
        for(int i=0; i<max/2; i++)
        {
            if (rear == arr.length){
                int[] nw_arr = new int[arr.length * 2];
                System.arraycopy(arr, 0, nw_arr, 0, arr.length);
                arr = nw_arr;
            }
            arr[rear++] = i;
        }
    }

    @Override
    void insert()
    {
        for(int idx : randIndex)
        {
            // expand size
            if (rear == arr.length){
                int[] nw_arr = new int[arr.length * 2];
                System.arraycopy(arr, 0, nw_arr, 0, arr.length);
                arr = nw_arr;
            }
            // shift
            for(int i=rear; i>idx; i--)
            {
                arr[i] = arr[i-1];
            }
            // insert
            arr[idx] = idx;
            rear++;
        }
    }

    @Override
    void find()
    {
        for(int idx : randIndex) {
            int x = arr[idx];
        }
    }

    @Override
    void print()
    {
        for(int i=0; i<rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}