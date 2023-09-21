package lab01;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Validate {

    // Validates a given letter soup
    public static char[][] valSoup(List<String> input) {
        // Calculate the size of the letter soup
        int size = input.get(0).length();

        char[][] soup = new char[size][size];
        String line;

        // Check if size is valid
        if (size > 40) {
            System.out.println("(Validate.valSoup) - Error: matrix exceeds 40x40 size");
            System.exit(0);
        }
        else if (size > input.size()) {
            System.out.println("(Validate.valSoup) - Error: not enough lines for supposed matrix");
            System.exit(0);
        }

        for (int i = 0; i < size; i++) {
            line = input.get(i);
            
            if (line.isEmpty()) {
                System.out.println("(Validate.valSoup) - Error: empty line");
                System.exit(0);
            }
            else if (line.length() != size) {
                System.out.println("(Validate.valSoup) - Error: matrix line has wrong length");
                System.exit(0);
            }
            else if (!line.matches("[a-zA-Z]+")) {
                System.out.println("(Validate.valSoup) - Error: matrix contains non-alphabetic characters");
                System.exit(0);
            }
            else if (!line.equals(line.toUpperCase())) {
                System.out.println("(Validate.valSoup) - Warning: matrix contained lowercase character");
                line = line.toUpperCase();
            }

            soup[i] = line.toCharArray();
        }

        return soup;
    }

    // Validates a given list of words
    public static List<String> valWordList(List<String> input, int start) {
        // The argument "start" represents the place where to start reading
        // To avoid manipulating the input data in WSSolver, we use start to skip the lines that represent the matrix

        List<String> wordLst = new ArrayList<>();
        String line;
        String[] words;

        // Filter the input in case the letter soup is part of it
        List<String>filtInput = input.subList(start, input.size());

        for (int i = 0; i < filtInput.size(); i++) {
            
            line = filtInput.get(i);

            if (line.isEmpty()) {
                System.out.println("(Validate.valWordList) - Error: empty line");
                System.exit(0);
            }

            // Split the line and get the words
            words = filtInput.get(i).split("(\\p{javaWhitespace}|;|,)+");

            for (String word : words) {
                if (word.length() < 3) {
                    System.out.println("(Validate.valWordList) - Error: word is too short (<3 letters)");
                    System.exit(0);
                }
                else if (!word.matches("[a-zA-Z]+")) {
                    System.out.println("(Validate.valWordList) - Error: word contains non-alphabetic characters");
                    System.exit(0);
                }

                wordLst.add(word);
            }
        }
        return wordLst;
    }

    // Validates an index in relation to an array
    public static boolean isValidIndex(char[][] arr, int i, int j) {
        try {
            int test = arr[i][j];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // Validates file existence
    public static Scanner isValidFile(String input) throws Exception{
        try {
            File ficheiro = new File("lab01/"+input);
            Scanner sc = new Scanner(ficheiro);
            return sc;
        }
        catch (Exception error) {
            System.out.println("(Validate.isValidFile) - Input file not found");
            System.exit(0);
        }
        return null;
    }

    // Validates an index in relation to the contents of the array
    public static boolean isValid(int[] position, char[][] soup) {
        if (soup[position[0]][position[1]] != '\0') // if the original position already has some word there
            return false;
        else
            return true;
    }
    
    // Returns the necessary info relating to the given direction
    public static int[] checkDirection(int dir) {

        Direction betterDir = Direction.values()[dir];
        int[] dirsRowCol = new int[2]; 

        switch (betterDir) {
            case U:
                dirsRowCol[0] = -1; dirsRowCol[1] = 0;
                break;
            case UR:
                dirsRowCol[0] = -1; dirsRowCol[1] = 1;
                break;
            case R:
                dirsRowCol[0] = 0; dirsRowCol[1] = 1;
                break;
            case DR:
                dirsRowCol[0] = 1; dirsRowCol[1] = 1;
                break;
            case D:
                dirsRowCol[0] = 1; dirsRowCol[1] = 0;
                break;
            case DL:
                dirsRowCol[0] = 1; dirsRowCol[1] = -1;
                break;
            case L:
                dirsRowCol[0] = 0; dirsRowCol[1] = -1;
                break;
            case UL:
                dirsRowCol[0] = -1; dirsRowCol[1] = -1;
                break;
            default:
                return null;
        }

        return dirsRowCol;
    }
}
