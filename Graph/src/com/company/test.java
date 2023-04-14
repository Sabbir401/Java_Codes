package com.company;

public class test {
    static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'S'};
    static int e[] = {2, 2, 2, 2, 2, 2, 3, 3};
    static int list[][] = {{3, 7}, {4, 7}, {5, 7}, {0, 6}, {1, 6}, {2, 6}, {3, 4, 5}, {0, 1, 2}};
    static int[] checked = new int[20];
    static int[] stk = new int[20];
    static int top =0;
    static int[] parent = new int[20];

    public static void main(String[] args) {
        for(int j=0;j<=7;j++){
            parent[j]=-1;
        }

        int f;
        push(7);
        while(top!=0){
            int n=stk[top-1];
            f=0;
            for (int i =0; i<e[n];i++){
                if(notchecked(list[n][i])==1){
                    push(list[n][i]);
                    parent[list[n][i]] = n;
                    f=1;
                    break;
                }
            }
            if(f==0){
                pop();
            }
        }
        for(int i=2;i!=-1;i=parent[i]){
            if(parent[i]==-1){
                break;
            }
            System.out.print(c[i]);
            System.out.println(" parent "+c[parent[i]]);
        }


    }
    static int pop(){
        top--;
        System.out.print(c[stk[top]]+" ");
        return stk[top];
    }

    static int notchecked(int n){
        if(checked[n]==1){
            return 0;
        }
        return 1;
    }
    static void push(int n){
        checked[n]=1;
        stk[top]=n;
        top++;
    }

}
