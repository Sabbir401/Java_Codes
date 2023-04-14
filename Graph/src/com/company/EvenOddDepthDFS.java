package com.company;

public class EvenOddDepthDFS {
    static int[] c={1,2,3,4,5,6,7,8,9,10,11,12};
    static int e[]={3,2,0,2,2,0,2,0,0,0,0,0};
    static int list[][]={{1,2,3},{4,5},{0},{6,7},{8,9},{0},{10,11},{0},{0},{0},{0},{0}};
    static int[] checked = new int[20];
    static int[] stk = new int[20];
    static int[] depth = new int[20];

    static int top = 0;

    public static void main(String[] args) {

        System.out.println("DFS traversal:");
        int i, n, f ;
        push(0);

        while (top != 0) {
            n = stk[top-1];
            f = 0;
            for (i = 0; i < e[n]; i++) {
                if (notChecked(list[n][i]) == 1) {
                    push(list[n][i]);
                    depth[list[n][i]] = depth[n] + 1;
                    f = 1;
                    break;
                }
            }
            if (f == 0)
                pop();
        }
        System.out.println("Even Depth : ");
        for(int z=0;z<12; z++){
            if(depth[z]%2==0)
                System.out.print(c[z]+" ");
        }
        System.out.println();
        System.out.println("Odd Depth : ");
        for(int z=0;z<12; z++){
            if(depth[z]%2!=0)
                System.out.print(c[z]+" ");
        }
    }

    static int notChecked(int n) {
        if (checked[n] == 1)
            return 0;
        return 1;
    }

    static int pop(){
        top--;
//        System.out.print(c[stk[top]]+ " ");
        return stk[top];
    }

    static void push(int n){
        checked[n]=1;
        stk[top]=n;
        top++;
    }
}
