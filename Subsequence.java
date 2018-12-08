import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/**
 * Class to that searches through a given file for a user inputted subsequence.
 * 
 * @author Joseph Oliva
 * 
 */
public class Subsequence
{
    Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    String firstLine;
    File file;

    public Subsequence (File file) throws FileNotFoundException
    {
        this.file = file;
    }

    public void addSubsequence () throws FileNotFoundException
    {
        Scanner subsequenceFile = new Scanner(file);
        Scanner in = new Scanner(System.in);
        String subsequence = "";
        String line = "";
        int currPosition = 0;
        int count = 0;
        boolean subFound = true;

        System.out.println("Please enter the length of the subsequences to search for.");
        int length = in.nextInt();

        firstLine = subsequenceFile.nextLine();
        System.out.println("Loading genome from file with description:" + firstLine);

        while (subsequenceFile.hasNext())
        {
            line += subsequenceFile.nextLine();
        }
        //line = subsequenceFile.nextLine();
        for (int x = 0; x < line.length(); x++)
        {
            //make kmer
            for (int i = 0; i < length; i++)
            {
                if (currPosition + 4 > line.length())
                {
                    subFound = false;
                }
                else
                {
                    subsequence += line.charAt(currPosition + i);
                    subFound = true;
                }
            }

            if (subFound)
            {
                count++;
            }

            if (map.containsKey(subsequence))
            {
                map.get(subsequence).add(currPosition);
            }
            else
            {
                map.put(subsequence, new ArrayList<Integer>());
                map.get(subsequence).add(currPosition);
            }
            subsequence = "";
            currPosition++;
        }
        System.out.println("Sequences of size " + length + " count: " + count);
        System.out.println("Map Size: " + (map.size() - 1));
        findSequence();
    }

    public void findSequence()
    {
        Scanner in = new Scanner(System.in);
        String array = "[";

        System.out.println("Enter new sequence. Enter 'q' to quit...");
        String userResponse = in.next();
        userResponse = userResponse.toUpperCase();

        while (userResponse.charAt(0) != 'Q')
        {
            System.out.println("Sequence: " + userResponse);

            long start = System.nanoTime();
            for (int i = 0; i != 999999; i++)
            {
                for (int position : map.get(userResponse))
                {
                }
            }

            for (int position : map.get(userResponse))
            {
                array += position + ", ";
            }
            long elapsedTime = (System.nanoTime() - start) / 1000000;

            array = array.substring(0, array.length() - 2);
            array += "]";

            System.out.println(array);
            System.out.println("There are " + map.get(userResponse).size() + " locations with the sequence " + userResponse);

            System.out.println("Search time: " + elapsedTime + " ms.");

            System.out.println("Enter new sequence. Enter 'q' to quit...");
            userResponse = in.next();
            userResponse = userResponse.toUpperCase();
            array = "[";
        }
    }
}