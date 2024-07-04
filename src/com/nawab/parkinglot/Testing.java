package com.nawab.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Testing {
    public void printHello() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String data = reader.readLine();
            System.out.println(data);
            break;
        }
        reader.close();
    }

    public void printFromFile(String fileName) throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("CustomeError");
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            System.out.println(input);
            input = reader.readLine();
        }
    }
    public int printValues(int a){
        return a*a;
    }
}
