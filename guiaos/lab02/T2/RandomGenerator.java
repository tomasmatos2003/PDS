package lab01;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RandomGenerator {

    public static int[] GenerateRandomPosition(String word, int size, char[][] soup) {
        int[] position = new int[2];
        
        // generate two random ints from 0 to size
        do {
            Random rand = new Random();
            position = new int[2];
            position[0] = rand.nextInt(size);
            position[1] = rand.nextInt(size);
        } while (Validate.isValid(position, soup) == false);

        // generates a random position in the soup for the word to be inputed, and
        // checks if it is valid
        return position;

    }

    // returns a list with all possible valid directions the word can be inputed in
    // the soup
    public static List<Integer> GenerateDirections(String word, int[] position, char[][] soup) {
        List<Integer> validDirections = new ArrayList<Integer>();
        // check all the possible directions the word can be inputed in the soup
        for (int i = 0; i < 8; i++) {
            if (CheckProblems(position, i, word, soup) == true) {
                validDirections.add(i);
            }
        }
        return validDirections;
    }

    public static int GenerateRandomDirection(String word, int[] position, char[][] soup) {
        // generates a random direction for the word to be inputed in the soup
        List<Integer> validDirections = GenerateDirections(word, position, soup);

        if (validDirections.size() != 0){           
            //System.out.println("word = " + word + " valid directions = " + validDirections + "");
            Random rand = new Random();
            int direction = rand.nextInt(validDirections.size());
            return validDirections.get(direction);
        }
        return -1;
    }

    public static boolean CheckProblems(int[] position, int direction, String word, char[][] soup) {
        // returns true if there are no problems with the word being inputed in the soup
        int wordRemainingLen = word.length()-1;
        int[] dirsRowCol = Validate.checkDirection(direction);
        int rowDir, colDir, k;

        rowDir = dirsRowCol[0]; colDir = dirsRowCol[1];

       /*  System.out.println(".......");
        System.out.printf("x=%d , y=%d\n", position[0]+rowDir*wordRemainingLen, position[1]+colDir*wordRemainingLen);
        System.out.println("......."); */

        if (Validate.isValidIndex(soup, position[0]+rowDir*wordRemainingLen, position[1]+colDir*wordRemainingLen)) {
            for(k=0; k < word.length(); k++) {
                if (soup[position[0]+rowDir*k][position[1]+colDir*k] != '\0') {
                    break;
                }
            }
            if (k == word.length()) { return true; }
        }

        return false;
        
        // checks if the word will colide with another word in the soup
        // if it does, returns false
        // if it doesn't, returns true
    }
}
