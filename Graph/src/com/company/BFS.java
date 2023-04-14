package com.company;

import java.util.Scanner;

public class BFS {
    static char[] c={'A','B','C','D','E','F','G','S'};
    static int e[]={2,2,2,2,2,2,3,3};
    static int list[][]={{3,7},{4,7},{5,7},{0,6},{1,6},{2,6},{3,4,5},{0,1,2}};
    static int[] checked=new int[20];
    static int[] que=new int[20];
    static int first=0,last=0;
    static int[] parent = new int[20];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int j=0;j<=7;j++){
            parent[j]=-1;
        }
        int i,n;
        enq(7);
        while(first<last){
            n=dq();
            for(i=0;i<e[n];i++){
                if(notChecked(list[n][i])==1)
                    enq(list[n][i]);
                parent[list[n][i]] = n;
            }
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
    static int notChecked(int n){
        if(checked[n]==1)
            return 0;
        return 1;
    }
    static void enq(int n){
        checked[n]=1;
        que[last]=n;
        last++;
    }
    static int dq(){
        System.out.print(c[que[first]]+" ");
        first++;
        return que[first-1];
    }
}
