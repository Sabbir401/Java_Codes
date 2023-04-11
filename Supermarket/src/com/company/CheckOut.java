package com.company;

import java.io.FileWriter;

public class CheckOut {

    public void out(String x, String y){
        try{
            FileWriter writer = new FileWriter("D:\\JAVA IDEA\\SuperMarket\\FileReadWrite\\Login.txt");
            writer.write("Name: "+x+"\n"+"Contact No: "+y+"\n\n");
            writer.close();
        }catch(Exception e){

        }
    }


}
