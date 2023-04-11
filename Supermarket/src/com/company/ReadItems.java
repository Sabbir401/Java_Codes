package com.company;

import java.io.File;
import java.util.Scanner;

public class ReadItems {
    public String FreshItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Fresh.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String FrozenItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Frozen.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String DairyItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Dairy.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String SpiceItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Spice.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String SnackItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Snack.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String GrainsItem(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Grains.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }

    public String Name(){
        String id, result = "";
        try{
            File file = new File("D:\\JAVA IDEA\\Supermarket\\FileReadWrite\\Login.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                id = scan.nextLine();
                result= result+id+"\n";
            }
        }catch(Exception e){
            System.out.println("File Not Found Exception");
        }
        return result;
    }


}

