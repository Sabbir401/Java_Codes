package com.company;

import java.util.Arrays;
import java.util.Scanner;

class Kruskal {
    static Edge result_copy[] = new Edge[10];
    int check=0;
    static int MIN_cost = 999;
    Kruskal(){
        for (int w = 0; w < result_copy.length; w++) {
            result_copy[w] = new Edge();
        }
    }


    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {

        int src, dest, weight;

        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    int V, E; // V−> no. of vertices & E−>no.of edges
    Edge edge[]; // collection of all edges

    // leader is the concept of maintaining the subtree.
    // initially each node will be its own leader
    // after union of 2 sub tree the leader of thoes tree will be same.
    int leader[];

    // Creates a graph with V vertices and E edges
    Kruskal(int v, int e) {
        V = v;
        E = e;
        leader = new int[V];
        edge = new Edge[E];

        for (int i = 0; i < e; ++i) {
            edge[i] = new Edge();
        }
    }

    //A function to find the leader of node n
    int Find(int n) {
        return leader[n];
    }

    // A function that does union of two subtree and sets the nodes under same leader

    void Union(int rootU, int rootV) {
        int newLeader;
        if (rootU < rootV) {
            newLeader = rootU;
            for (int i = 0; i < V; i++) {
                if (leader[i] == rootV) {
                    leader[i] = newLeader;
                }
            }
        } else {
            newLeader = rootV;

            for (int i = 0; i < V; i++) {
                if (leader[i] == rootU) {
                    leader[i] = newLeader;
                }
            }
        }
    }

    void KruskalMST() {

        //System.out.println(" Check = "+ check);
        // Tnis will store the resultant MST
        Edge result[] = new Edge[V - 1];

        // An index variable, used for sorted edges
        int i = 0;
        for (i = 0; i < result.length; i++) {
            result[i] = new Edge();
        }
        // Step 1: Sort all the edges in non−decreasing
        // order of their weight. If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);

        // Assign each node as its own leader initially
        for (i = 0; i < V; ++i) {
            leader[i] = i;
        }

        i = 0; // Index used to pick next edge

        // Check all edge to construct the MST
        // Smallest weighted edge will be picked first
        for (int e = 0; e < edge.length; e++) {
            Edge next_edge = edge[e];
            // find the leader of the nodes in edge e
            int x = Find(next_edge.src);
            int y = Find(next_edge.dest);
            // If including this edge does’t cause cycle, include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[i++] = next_edge;
                Union(x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " + "the constructed MST");

        int minimumCost = 0;
        for (i = 0; i < result.length; i++) {
            System.out.println(result[i].src + " −− " + result[i].dest + " == "+ result[i].weight);
            if(check==0){
                result_copy[i]=result[i];
                //System.out.println("For result_copy "+result_copy[i].src+"--"+result_copy[i].dest+" = "+result_copy[i].weight+" i = "+i);
            }
            minimumCost += result[i].weight;
        }

        if(MIN_cost>minimumCost && check == 99)
            MIN_cost=minimumCost;
        if(check==0)
            System.out.println("Minimum Cost Spanning Tree " + minimumCost);
        else
            System.out.println("Second Minimum Cost Spanning Tree " + minimumCost);
        check=99;
    }

    // Driver Code
    public static void main(String[] args) {



        int V = 0; // Number of vertices in graph
        int E = 0; // Number of edges in graph

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of Nodes: ");
        V = input.nextInt();
        System.out.println("Enter number of Edges: ");
        E = input.nextInt();
        Kruskal graph = new Kruskal(V, E);


        for(int q=0; q<E; q++){
            System.out.println("For edge "+q+": Enter Source Destination Weight");
            graph.edge[q].src = input.nextInt();
            graph.edge[q].dest = input.nextInt();
            graph.edge[q].weight = input.nextInt();
        }

//    for(int q=0; q<E; q++){
//        System.out.println("For edge "+graph.edge[q].src+"--"+graph.edge[q].dest+" = "+graph.edge[q].weight);
////
//    }
//    for(int q=0; q<V-1; q++){
//        //System.out.println("For result_copy "+result_copy[q].src+"--"+result_copy[q].dest+" = "+result_copy[q].weight);
////
//    }
        // 4 5 0 1 10 0 2 6 0 3 5 1 3 15 2 3 4
        // Function call
        graph.KruskalMST();

        for (int i = 0; i < V-1; i++) {
            System.out.println("\n\nsecond mst********\n");
            System.out.println(result_copy[i].src + " −− " + result_copy[i].dest + " == "+ result_copy[i].weight);
            for( int j=0; j<E; j++){
                if(result_copy[i].src==graph.edge[j].src && result_copy[i].dest==graph.edge[j].dest  && result_copy[i].weight==graph.edge[j].weight){

                    int we = graph.edge[j].weight;
                    graph.edge[j].weight=999;
                    graph.KruskalMST();
                    for(int q=0; q<E; q++){

                        if(result_copy[i].src==graph.edge[q].src && result_copy[i].dest==graph.edge[q].dest)
                            graph.edge[q].weight= we;
                    }

                    break;

                }
            }
        }
        System.out.println("\nSecond best Minimum Cost Spanning Tree " + MIN_cost);
    }
}
