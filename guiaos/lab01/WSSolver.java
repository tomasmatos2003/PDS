import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WSSolver {
    public static void main(String[] args) {
        File wordsFile = new File(args[0]);
        List<String> puzzle = new ArrayList<>();
        List<String> wordLines = new ArrayList<>();
        try (Scanner sc = new Scanner(wordsFile)) {
            String line = sc.nextLine();
            int puzzleSize = line.length();
            puzzle.add(line);
            for (int i = 1; i < puzzleSize; i++) {
                puzzle.add(sc.nextLine());
            }

            while (sc.hasNext()) {
                line = sc.nextLine();
                wordLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            return;
        }

        Puzzle wordSearchPuzzle = new Puzzle(puzzle, wordLines);
        // System.out.println(wordSearchPuzzle.toString());

        PuzzleSolver.printSolution(wordSearchPuzzle);
    }
}