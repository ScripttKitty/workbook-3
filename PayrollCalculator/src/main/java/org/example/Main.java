package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

try {

    BufferedReader bufReader = new BufferedReader(
            new FileReader("employees.csv"));


    String input;
    while((input = bufReader.readLine()) != null) {
        System.out.print(input);
        String [] tokens = input.split("\\ |");
        System.out.println("\n" + tokens[0]);
    }


    bufReader.close();
     }
catch(IOException e){
    e.printStackTrace();
    }
    }
}