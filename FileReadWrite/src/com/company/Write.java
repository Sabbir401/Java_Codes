package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public void WR() throws IOException {
        String str = "My name is opi."+" I'm 22 years old";
        File file = new File("F:\\opi.txt");
        FileWriter fw = new FileWriter(file, true);
        fw.write(str+"\n");
        fw.flush();

    }
}
