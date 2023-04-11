package com.company;

public class Node {
    String name;
    double price;
    int quan;
    Node next;

    public Node(String name, double price, int quan){
        this.name = name;
        this.price = price;
        this.quan = quan;
        this.next = null;
    }
}
