/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Abel Thomas
 */

package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution45 {

    public static void main(String[] args) throws IOException {

        /*
        read input file given
        replace all instances of utilize with use
        output the modified file
         */

        ClassLoader classLoader = Solution45.class.getClassLoader();

        File file = new File(classLoader.getResource("exercise45_input.txt").getFile());
        Scanner sc = new Scanner(file);

        Scanner s = new Scanner(System.in);

        System.out.print("\nEnter the name of Output File : ");

        String outputfile = s.next();

        FileWriter writer = new FileWriter(outputfile);

        try
        {
            while( sc.hasNext() )
            {
                String user = sc.nextLine();
                user = user.replaceAll("utilize", "use");
                writer.write(user);

                writer.write("\n");
            }
        }
        finally
        {
            sc.close();
        }
        writer.close();
        System.out.println("\nSuccessfully Modified!!");
    }
}
