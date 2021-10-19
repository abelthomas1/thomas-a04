/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Abel Thomas
 */

package baseline;

import java.io.*;

import java.util.*;

public class Solution41 {

        /*
        read data from the text file given
        determine the alphabetic order of the names within the file
        sort the names according to this order
        output the sorted list of names
         */

    public static void readNames(Scanner input, ArrayList<String> names) {
        while (input.hasNextLine()) {
            names.add(input.nextLine());
        }
    }

    public static void outputNames(ArrayList<String> names) throws IOException {
        FileWriter output = new FileWriter("exercise41_output.txt");
        output.write("Total of " + (names.size() - 1) + " names\n");
        output.write("--------------------\n");

        for (String i : names) {
            output.write(i + "\n");
        }
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = Solution41.class.getClassLoader();

        Scanner inputFile = new Scanner(new File(classLoader.getResource("exercise41_input.txt").getFile()));
        ArrayList<String> names = new ArrayList<String>();

        readNames(inputFile, names);

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        inputFile.close();

        try {
            outputNames(names);
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}