package com.company;

import java.util.Scanner;

public class AdjacencyMatrix {
    static int[][] matrix = new int[20][20];

    public static void main(String[] args) {
        int e = 7, n = 5;
        Inmatrix(e);
        System.out.println("Output:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void Inmatrix(int e) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter The Edges:");
        int i;
        int j, k;

        for (i = 0; i < e; i++) {// this loop runs e times to take the all edges.
            j = sn.nextInt();
            k = sn.nextInt();
            matrix[j][k] = matrix[k][j]=1;
        }
    }
}
