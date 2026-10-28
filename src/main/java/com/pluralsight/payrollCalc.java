package com.pluralsight;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;


public class payrollCalc {
    public static void main(String[] args) {

        String fileName = "src/main/resources/employees.csv";

        try {
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           String line = bufferedReader.readLine(); // reads and throws away header
           line = bufferedReader.readLine();
           while (line!= null){
               Employee employee = parseEmployee(line);
               System.out.println(employee.getName());
               System.out.printf("%d   %s  %f/n",
                       employee.getEmployeeId(), employee.getName(), employee.grossPay());
               line = bufferedReader.readLine();

           }
        }
        catch (FileNotFoundException e) {
            System.out.println("erm, that file does not exist " + fileName);;
        }
        catch (IOException e){
            System.out.println("erm there is an issue");
        }


    }

    private static Employee parseEmployee(String employeeCsv) {
        String[] lineParts = employeeCsv.split(Pattern.quote("|"));
         int id = Integer.parseInt(lineParts[0]);
         String name = lineParts[1];
         double hoursWorked = Double.parseDouble(lineParts[2]);
         double payRate = Double.parseDouble(lineParts[3]);


        Employee employee = new Employee(id,name,hoursWorked,payRate);

        return employee;
    }
}
