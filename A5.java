import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.InputMismatchException;
/**
 * Class that reads a fasta file for a user given subsequence.
 * 
 * @author Joseph Oliva
 * 
 */
public class A5
{
    /**
     * Driver class for the program.
     */
    public static void main (String args[]) throws FileNotFoundException
    {
        fileLoad();
    }

    /**
     * Loads in the file and runs the program.
     */
    private static void fileLoad()
    {
        Scanner in = new Scanner(System.in);

        String file = "";
        File subsequenceFile;
        boolean rightFile = false;
        Subsequence sub;

        while (!rightFile)
        {
            try
            {
                System.out.println("Please enter the file to be used");
                file = in.next();

                subsequenceFile = new File(file);
                sub = new Subsequence(subsequenceFile);
                rightFile = true;
                if (rightFile)
                {
                    sub.addSubsequence();
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File " + file + " was not found.");
                System.out.println();
            }
        }
    }
}