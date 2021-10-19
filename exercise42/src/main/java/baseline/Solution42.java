/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Abel Thomas
 */

package baseline;

import java.util.*;
import java.io.*;

public class Solution42 {

    public void printDetails(String filename) {

         /*
        read in the data from the input file
        process the data in between each comma as a record
        sort the data into a table
        output the table
         */

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            File file = new File(classLoader.getResource("exercise42_input.txt").getFile());
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }

    public static void main(String[] args) {

        Solution42 emp = new Solution42();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.printDetails("exercise42_input.txt");
    }
}