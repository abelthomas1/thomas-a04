/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Abel Thomas
 */

package baseline;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Solution46 {

        /*
        read input file
        determine the frequency of each word in the file
        display a histogram showing this frequency
         */

    static void countWordsFrequency(String str)
    {
        Map<String,Integer> mp=new TreeMap<>();
        String arr[]=str.split(" ");

        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else
            {
                mp.put(arr[i],1);
            }
        }

        for(Map.Entry<String,Integer> entry:
                mp.entrySet())
        {
            System.out.print(entry.getKey()+
                    " : ");
            for(int i=0;i<entry.getValue();i++)
            {
                System.out.print("*");
            }

            System.out.print("\n\n");
        }
    }
    public static String readFileIntoString(String path, Charset encoding) throws IOException
    {
        String content;
        try (Scanner scanner = new Scanner(new File(path), String.valueOf(encoding))) {
            content = scanner.useDelimiter("\\A").next();
        }

        return content;
    }

    public static void main(String[] args)
    {
        String filePath = "/Users/abel/IdeaProjects/exercise46/src/main/resources/exercise46_input.txt";

        String fileContent = null;
        try {
            fileContent = readFileIntoString(filePath, StandardCharsets.UTF_8);
            int nuul=0;
            fileContent = fileContent.replaceAll("(\\r|\\n|\\t)", " ");
            fileContent=fileContent.replaceAll("\\s+"," ").trim();
            int b=0;
        } catch (IOException e) {
            e.printStackTrace();
        }

        countWordsFrequency(fileContent);
    }
}