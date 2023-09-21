package lab01;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.util.Comparator;
import java.util.ArrayList;


public class WSSolver {
    public static void main(String[] args) throws IOException {  
        
        Scanner input = new Scanner(new File("lab01/" + args[0]));
        List<String> data = ReadData.read(input);
        //System.out.println(data);
        input.close();
        
        char[][] soup = Validate.valSoup(data);
        List<String> words = Validate.valWordList(data, soup.length);
        
        int[][] info = solve(soup, words);
        char[][] cSoup = cleanSoup(info, words, soup.length);

        Display.displayWordList(words, info);
        Display.displaySoup(cSoup,true);
    }

    public static int[][] solve(char[][] soup, List<String> wordLst) {

        // Sort the words, in order to prioritize longer words (FAROL > FARO)
        List<String> words = new ArrayList<>(wordLst);
        words.sort(Comparator.comparingInt(String::length).reversed());

        // Each column of "info" represents a different word
        int[][] info = new int[3][words.size()];
        int dir,sol;

        // Matrix to check if initial letter has already been used in certain direction
        // The array stored in the table has 8 entries each corresponding to 1 direction
        // If an element has the character "X", that means that that direction has already been used
        char[][][] used = new char[soup.length][soup.length][8];
        
        for (int w=0; w < words.size(); w++) {
            // Convert to uppercase, to make comparing easier
            String word = words.get(w);
            word = word.toUpperCase();

            // Obtain the first letter, then search for it in the soup
            char initial = word.charAt(0);

            sol = 0;
            for (int i=0; i < soup.length; i++) {
                for (int j=0; j < soup.length; j++) {
                    // Find a letter equal to "initial" and test the word in all 8 directions
                    if (soup[i][j] == initial) {
                        dir = testWordInSoup(soup, word, i, j);
                        
                        if (dir > -1 && used[i][j][dir] != 'X') { 
                            info[0][w] = i; info[1][w] = j; info[2][w] = dir;
                            used[i][j][dir] = 'X';
                            sol = 1;
                            break;
                        }
                    }
                }
                if (sol == 1) {break;}
            }
        }

        return info;
    }

    public static int testWordInSoup(char[][] soup, String word, int i, int j) {
        int wordRemainingLen = word.length()-1;
        int rowDir, colDir, k;
        int[] dirsRowCol;

        for (int dir = 0; dir < 8; dir++) {
            
            dirsRowCol = Validate.checkDirection(dir);
            rowDir = dirsRowCol[0]; colDir = dirsRowCol[1];

            // Check if there is space for the word in the given direction, by validating the index of the last letter
            if (Validate.isValidIndex(soup, i+rowDir*wordRemainingLen, j+colDir*wordRemainingLen)) {
                for(k=1; k < wordRemainingLen; k++) {
                    if (soup[i+rowDir*k][j+colDir*k] != word.charAt(k)) {
                        break;
                    }
                }
                if (k == wordRemainingLen) { return dir; }
            }
        }
        return -1;
    }

    public static char[][] cleanSoup(int[][] info, List<String> words, int size) {

        char[][] cSoup = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cSoup[i][j] = '.';
            }
        }

        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort(Comparator.comparingInt(String::length).reversed());

        for (int k = 0; k < sortedWords.size(); k++) {
            String word = sortedWords.get(k).toUpperCase();
            int startI = info[0][k], startJ = info[1][k], dir = info[2][k];

            int[] dirsRowCol = Validate.checkDirection(dir);
            int rowDir = dirsRowCol[0], colDir = dirsRowCol[1];

            for (int w = 0; w < word.length(); w++) {
                cSoup[startI+rowDir*w][startJ+colDir*w] = word.charAt(w);
            }
        }

        return cSoup;
    }
}