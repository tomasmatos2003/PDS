package lab01;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseInput {
    // makes sure that the arguments are correct
    // extracts the words from the given input file and returns a list with them
    public static List<String> parseArguments(String[] args) throws Exception {

        List<String> arguments = new ArrayList<String>();
        // for ease of use, the 1st element of the array will be the size of the soup
        // that will be later removed from the array

        // add all arguments to an arraylist
        for (int i = 0; i < args.length; i++) {
            arguments.add(args[i]);
        }

        
        // check if -i has been passed
        // if it has been passed, also check if its a .txt file
        if (!arguments.contains("-i")) {
            System.out.println("No input file has been given ( -i file )");
            System.exit(0);
        } 
        else {
            try {
                if (!arguments.get(arguments.indexOf("-i") + 1).contains(".txt")) 
                {
                    System.out.println("Please provide a .txt with the input words");
                    System.exit(0);
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Please provide a .txt with the input words");
                System.exit(0);
            }
        }

      

        // check if -s has been passed
        // if it has been passed, also check if its a positive integer
    
        if (!arguments.contains("-s")) {
            System.out.println("No word letter soup size has been given ( -s size )");
            System.exit(0);
        } 
        else {
            try {
                if (Integer.parseInt(arguments.get(arguments.indexOf("-s") + 1)) < 0) {
                    System.out.println("Please provide a positive integer for the size of the word soup");
                    System.exit(0);
                }
                } 
                catch (Exception e) {
                System.out.println("Please provide a positive integer for the size of the word soup");
                System.exit(0);
                }
        }
        
        // check if max size is exceeded
        int indexofsize = arguments.indexOf("-s");
        if (Integer.parseInt(arguments.get(indexofsize + 1)) > 40) {
            System.out.println("Max size of the word soup is 40 x 40");
            System.exit(0);
        }

        String inputfile = arguments.get(arguments.indexOf("-i") + 1);
        Scanner sc = Validate.isValidFile(inputfile);
        
        List<String> words = ReadData.read(sc);
        words = Validate.valWordList(words, 0);

        int size = Integer.parseInt(arguments.get(arguments.indexOf("-s") + 1));
        words.add(0, Integer.toString(size));

        return words;
    }


    public static void AssertSize(int size, List<String> words) {
        // find max length of words
        int maxlength = 0;
        for (int i = 1; i < words.size(); i++) {
            if (words.get(i).length() > maxlength) {
                maxlength = words.get(i).length();
            }
        }
        if (maxlength > size) {
            System.out.println("A word with length " + maxlength + " does not fit in the soup of size " + size);
            System.exit(0);
        }
    }
}
