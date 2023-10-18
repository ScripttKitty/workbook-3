package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type the number of the story you would like to read: \n" +
                    "1. Goldilocks and the Three Bears" + "\n" +
                    "2. Hansel and Gretel" + "\n" +
                    "3. Mary Had a Little Lamb");
            String userInput = scanner.nextLine().toLowerCase();

            FileInputStream file = null;

            switch(userInput) {
                case "1", "goldilocks":
                    file = new FileInputStream("goldilocks.txt");
                    System.out.println(file);
                    break;
                case "2", "hansel and gretel":
                    file = new FileInputStream("hansel_and_gretel.txt");
                    System.out.println(file);
                    break;
                case "3", "mary had a little lamb":
                    file = new FileInputStream("mary_had_a_little_lamb.txt");
                    break;
                default:
                    System.out.println("Your input does not match any of our stories. ");
            }

            Scanner scnr = new Scanner(file);

            String input;
            int lineCount = -1;
            while(scnr.hasNextLine()) {
                input = scnr.nextLine();
                lineCount++;
                System.out.println(lineCount +" " + input);
            }
            scnr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}