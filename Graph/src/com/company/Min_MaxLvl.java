package com.company;

import java.util.ArrayList;

public class Min_MaxLvl {
    static int[] c={1,2,3,4,5,6,7,8,9,10,11,12};
    static int e[]={3,2,0,2,2,0,2,0,0,0,0,0};
    static int list[][]={{1,2,3},{4,5},{0},{6,7},{8,9},{0},{10,11},{0},{0},{0},{0},{0}};
    static int[] checked=new int[20];
    static int[] que=new int[20];
    static int first=0,last=0;
    static int [] lvl =  new int [20];


    public static void main(String[] args) {
        ArrayList<Integer> node = new ArrayList<Integer>();
        int i,n,min=0,max=0;
        enq(0);
        while(first<last){
            n=dq();
            for(i=0;i<e[n];i++){
                if(notChecked(list[n][i])==1)
                    enq(list[n][i]);
                lvl[list[n][i]] = lvl[n] + 1;
                for(int j=0; j<lvl.length; j++){
                    if(lvl[j] < min){
                        min = lvl[j];
                    }
                    if(lvl[j] > max){
                        max = lvl[j];
                    }
                }
            }
            if(lvl[n]==min)
                System.out.println("Minimum level: "+c[n]);
            if(lvl[n]==max) {
                node.add(c[n]);
            }
        }
        System.out.print("Maximum lvl: ");
        for(int z =0; z < node.size(); z++){
            System.out.print(node.get(z)+" ");
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
        //System.out.print(c[que[first]]+" ");
        first++;
        return que[first-1];
    }
}
