package com.company;
import java.util.ArrayList;

class Graph {
    static String[] c = {"CSE 105", "CSE 103", "CSE 201","CSE 203", "CSE 205", "CSE 207","CSE 303", "CSE 309", "CSE 311", "CSE 313" };
    static int e[] = {3, 1, 1, 1, 2, 1, 1, 1, 1, 1};
    static int list[][] = {{2, 3, 9}, {0}, {4}, {5}, {6,7}, {8}, {9}, {9}, {9}, {4}};
    static int[] checked = new int[20];
    static int[] stk = new int[20];
    static int top = 0;
    static int[] arr = new int[10];
    ArrayList<Integer> node = new ArrayList<>();

    public void TopoSort() {
        int i, n, f = 0, j = 0;
        push(1);
        while (top != 0) {
            n = stk[top - 1];
            for (i = 0; i < e[n]; i++) {
                f = 0;
                if (notChecked(list[n][i]) == 1) {
                    push(list[n][i]);
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                pop();
                arr[j] = stk[top];
                j++;
            }
        }
    }

    public String Prerequisite(int x){
        Graph obj = new Graph();
        obj.TopoSort();
        String res = "";
        int i = arr.length;
        int j=1;
        while(i!= x){
            i--;
            res =  res+ j+". "+c[arr[i]]+"\n";
            j++;
        }
        return res;
    }

    public String display(){
        Graph obj = new Graph();
        obj.TopoSort();
        String result ="";
        int i = arr.length;
        int j=1;
        while(i!=0){
            i--;
            result =  result+ j+". "+c[arr[i]]+"\n";
            j++;

        }
        return result;
    }

    static int notChecked(int n) {
        if (checked[n] == 1)
            return 0;
        return 1;
    }
    static int pop(){
        top--;
        return stk[top];
    }
    static void push(int n){
        checked[n]=1;
        stk[top]=n;
        top++;
    }
}
