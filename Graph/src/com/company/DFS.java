package com.company;

import java.util.Scanner;

public class DFS {
    static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'S'};
    static int e[] = {2, 2, 2, 2, 2, 2, 3, 3};
    static int list[][] = {{3, 7}, {4, 7}, {5, 7}, {0, 6}, {1, 6}, {2, 6}, {3, 4, 5}, {0, 1, 2}};
    static int[] checked = new int[20];
    static int[] stk = new int[20];
    static int[] parent = new int[20];
    static int top = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int j=0;j<=7;j++){
            parent[j]=-1;
        }

        System.out.println("DFS traversal:");
        int i, n, f = 0;
        push(7);
        while (top != 0) {
            n = stk[top-1];
            f = 0;
            for (i = 0; i < e[n]; i++) {
                if (notChecked(list[n][i]) == 1) {
                    push(list[n][i]);
                    parent[list[n][i]] = n;
                    f = 1;
                    break;
                }
            }
            if (f == 0)
                pop();
        }
        System.out.println("\nEnter the targeted node: ");
        int x = scan.nextInt();
        for(int j=x;j!=-1;j=parent[j]){
            if(parent[j]==-1){
                break;
            }
            System.out.print(c[j]);
            System.out.println("  Parent = "+c[parent[j]]);
        }
    }

    static int notChecked(int n) {
        if (checked[n] == 1)
            return 0;
        return 1;
    }

    static int pop(){
        top--;
        System.out.print(c[stk[top]]+ " ");
        return stk[top];
    }

    static void push(int n){
        checked[n]=1;
       // System.out.print(c[n]+" ");
        stk[top]=n;
        top++;
    }
}
