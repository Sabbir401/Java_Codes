package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\JAVA IDEA\\FileReadWrite\\4.txt");
        FileReader fr = null;
    try{
    fr = new FileReader(file);
    }catch(Exception e){
    }
        Scanner in = new Scanner(fr);
    while(in.hasNext()) {
        String input = in.nextLine();
        String[] res = input.split("\"");
//        for(String str : res){
//
//                System.out.println(str);
//            }
//        }
        for (int i = 0; i <res.length; i++) {
            if (res[i].contains("+880")) {
                System.out.println(res[i]);
            }
        }


    }}
}
