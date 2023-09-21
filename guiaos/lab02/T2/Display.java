package lab01;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Display {
    
    public static void displaySoup(char[][] soup, boolean filtered) {

        for (char[] line : soup) {
            if (filtered) { System.out.println(String.valueOf(line).replace("", " ").trim()); }
            else { System.out.println(line); }
        }
    }

    public static void displayWordList(List<String> words, int[][] info) {
        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort(Comparator.comparingInt(String::length).reversed());

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int corrIndex = sortedWords.indexOf(word);
            System.out.printf("%-15s %-6d %d,%d\t%s\n", word, word.length(), info[0][corrIndex]+1, info[1][corrIndex]+1, Direction.values()[info[2][corrIndex]].label);
        }
    }

    public static void displaySimpleWords(List<String> words) {
        String outStr = words.toString();
        System.out.println(outStr.substring(1, outStr.length()-1));
    }
}
