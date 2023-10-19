package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {


        try {

            BufferedReader bufReader = new BufferedReader(
                    new FileReader("employees.csv"));


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
            }


            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}