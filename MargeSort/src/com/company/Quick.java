package com.company;

import java.util.Random;

public class Quick {
    public static int[] getData (){
        Random random = new Random();
// Generates random integers 0 to 49
        //int x = random.nextInt(50);
        int size = 10000;
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    public static void main(String[] args)
    {

        int i;
        int[] arr = { 18, 20, 26, 5, 9, 11, 15};
        //arr = getData();
        //int[] arr = { 30,25,22,20,18,16,17,15,14,13,12,10,9,7,6,4,3,2,1};
        //float start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        //float ending = System.currentTimeMillis();
        System.out.println("The sorted array is: ");
        for (i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    public static int partition(int a[], int beg, int end)
    {
        int left, right, temp, loc, flag;
        loc = left = beg;
        right = end;
        flag = 0;

        //loc = (beg + end) / 2;

        while (flag != 1)
        {
            while ((a[loc] <= a[right]) && (loc != right))
            {
                right--;
            }
            if (loc == right)
            {
                flag = 1;
            }
            else if (a[loc] > a[right])
            {
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if (flag != 1)
            {
                while ((a[loc] >= a[left]) && (loc != left))
                {
                    left++;
                }
                if (loc == left)
                {
                    flag = 1;
                }
                else if (a[loc] < a[left])
                {
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        System.out.print("-->");
        for(int i=beg; i<=end; i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("\n"+"beg "+beg+" end "+end+" loc "+loc+"\n");

        }
        return loc;
    }

    static void in_sort(int arr[], int beg, int end) {
        int n = beg;
        for (int i = 1; i <= end; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void quickSort(int a[], int beg, int end)
    {
        int loc;
        //if (beg < end  && (end - beg + 1) > 50 )
        if (beg < end )
        {
            loc = partition(a, beg, end);
            quickSort(a, beg, loc - 1);
            quickSort(a, loc + 1, end);
        }
        else{
            in_sort(a,beg,end);

        }

    }
}
