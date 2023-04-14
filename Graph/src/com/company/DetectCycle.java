package com.company;

import java.util.Scanner;

public class DetectCycle {
    //No cycle
//    static char[] c={'A','B','C','D','E'};
//    static int e[]={1,2,1,2,1};
//    static int list[][]={{1},{0,2},{1},{1,4},{3}};

//        Cycle
    static char[] c={'A','B','C','D','E'};
    static int e[]={2,3,2,2,1};
    static int list[][]={{1,2},{0,2,3},{0,1},{1,4},{3}};


    static int[] checked=new int[20];
    static int[] que=new int[20];
    static int first=0,last=0;
    static int[] parent = new int[20];


    public static void main(String[] args) {
        int i,n, flag=0;
        enq(0);
        while(first<last){
            n=dq();
            for(i=0;i<e[n];i++){
                if(notChecked(list[n][i])==1){
                    enq(list[n][i]);
                    parent[list[n][i]] = n;
                }
                else if(parent[n]!= list[n][i]){
                    flag =1;
                }
            }
        }
        if(flag==1){
            System.out.println("Cycle detected");
        }
        else{
            System.out.println("There is no Cycle");
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
        first++;
        return que[first-1];
    }
}
