package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\JAVA IDEA\\FileReadWrite\\number.txt");
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String id = input.next();
                String name = input.nextLine();
                System.out.println("ID: "+id+" Name: "+name);

            }
            input.close();

        }catch(Exception ex){

        }
    }
}
