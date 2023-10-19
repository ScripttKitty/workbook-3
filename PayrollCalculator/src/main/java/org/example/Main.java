package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name of the employee file to process:  ");
            String userInput = scanner.nextLine();

            BufferedReader bufReader = new BufferedReader(
                    new FileReader(userInput + ".csv"));

            System.out.println("Enter the name of the payment file to create:");
            String userInput2 = scanner.nextLine();

            boolean containsCsv = userInput.contains(".csv") ;
            FileWriter writer = new FileWriter(userInput2);



            String input = null;

           bufReader.readLine(); //throwaway the first line, it's a header

            while ((input = bufReader.readLine()) != null) {
                //System.out.print(input);
                String[] tokens = input.split("\\|");
                // System.out.println("\n" + tokens[0]);
               var employeeId = Integer.parseInt(tokens[0]);
               var employeeName = tokens[1];
               var hoursWorked = Double.parseDouble(tokens[2]);
               var  payRate = Double.parseDouble(tokens[3]);

               Employee employee = new Employee(employeeId, employeeName, hoursWorked, payRate);

               //System.out.println(employee);
                System.out.printf("\nID: %d \nName: %s \nPay:  $%.2f\n " , employee.getEmployeeId(), employee.getName(), employee.getGrossPay() );

                if(containsCsv){

                    writer.write(employee.getEmployeeId() + " | " +
                                                    employee.getName() + " | " +
                                                     employee.getGrossPay() +"\n" );
                }
                else {
                    String str = String.format("""
                            {"id" : " %d" , "name" : %s" , "gross pay" :  %.2f\\n }"
                             """, employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                }

            }
            writer.close();
            bufReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}