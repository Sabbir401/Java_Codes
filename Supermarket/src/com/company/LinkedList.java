package com.company;

import java.text.DecimalFormat;

public class LinkedList {
    public Node head = null;

    double a=0,b=0, c=0,vat;
    DecimalFormat df = new DecimalFormat("#.###");
    public void insert(String name, double price, int quan) {
        Node ptr = new Node(name, price, quan);

        if (head == null) {
            head = ptr;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = ptr;
        }
    }

    public String display() {
        String result = "";
        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            c = temp.price * temp.quan;
            result = result + i + ". " + temp.name + "   x   ("+temp.quan+")   =    " +c+"\n";
            temp = temp.next;
        }
        return result;
    }

    public void del(String x){
        int n = Integer.parseInt(x);
        if (n ==1){
            head = head.next;
        }else{
            Node ptr,temp1 = head,temp2;
            int i;
            for(i=2; i<n;i++){
                temp1 = temp1.next;
            }
            ptr = temp1.next;
            temp2 = ptr.next;
            temp1.next = temp2;
        }

    }

    public String total(){
        Node temp = head;
        while (temp != null) {
            a = a + temp.price*temp.quan;
            temp = temp.next;
        }
        String result = String.valueOf(a);
        a = 0;
        result =  "----------------------------------------------------\n"+"Gross amount  :              "+result;
        return result;
    }
    public String vat(){
        Node temp = head;
        while (temp != null) {
            a = a + temp.price*temp.quan;
            temp = temp.next;
        }
        String result = "";
        vat = (a/100)*5;
        String x = df.format(vat);
        result = "\n"+"Vat   (5%)          :              "+result+x;
        a=0;
        return result;
    }

    public String NetAmount(){
        Node temp = head;
        while (temp != null) {
            a = a + temp.price*temp.quan;
            temp = temp.next;
        }
        String result = "";
        b = a+vat;
        result = "\n"+"Net Amount     :             "+result+b;
        a=0;
        return result;
    }

}

