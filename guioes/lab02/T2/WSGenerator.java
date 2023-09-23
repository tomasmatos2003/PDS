package lab01;

import java.util.List;
import java.io.PrintStream;
import java.io.File;

public class WSGenerator {

    public static void main(String[] args) throws Exception {

        // parses the given input and returns a list with the words given in the input
        // file and the soup size
        List<String> words = ParseInput.parseArguments(args);
        //System.out.println(words);

        boolean output = CheckForOutput(args);
        
        int size = Integer.parseInt(words.get(0)); // the second index of words is the size of the soup
        words.remove(0); // removes the size from the list of words

        // makes sure that no word with size bigger than the size of the soup is given
        ParseInput.AssertSize(size, words);

        char[][] soup = new char[size][size];

        for (String word : words) {

            soup = DrawSoup.PlaceWordInSoup(word,soup,size);
           
        }

        //System.out.println("Positions are adjusted to start at 1,1");
        soup = DrawSoup.FillBlankSpaces(soup);

        // if an output file is given, print the soup to the file
        if (output) {
            String fileName = getFileName(args);
            try {
                File outputFile = new File("lab01/" + fileName);
                PrintStream out = new PrintStream(outputFile);
                // System.out.println(fileName);
                System.setOut(out);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        // print the soup
        Display.displaySoup(soup,false);
        Display.displaySimpleWords(words);
    }

    public static boolean CheckForOutput(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                try {
                    if (args[i + 1].contains(".txt")) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Warning: No output file name given");
                    System.exit(0);
                }
            }
        }
        return false;
    }

    public static String getFileName(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                return args[i + 1];
            }
        }
        return null;
    }

}
