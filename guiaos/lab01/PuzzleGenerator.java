import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class PuzzleGenerator {

    public static Puzzle generate(List<String> words, int puzzleSize) {
        boolean isPlaced = false;
        boolean hasFailed = false;
        int step[] = new int[2];
        int position[] = new int[2];
        int new_position[] = new int[2];
        int end_position[] = new int[2];

        int i;
        int wordLength;
        char character;
        char characterAtNewPosition;
        Random randomizer = new Random();
        char grid[][] = new char[puzzleSize][puzzleSize];
        
        for (String word : words) {
            word = word.toUpperCase();
            wordLength = word.length();

            isPlaced = false;

            while (isPlaced == false) {

                do {
                    step[0] = randomizer.nextInt(3) - 1;
                    step[1] = randomizer.nextInt(3) - 1;
                } while (step[0] == 0 && step[1] == 0);

                position[0] = randomizer.nextInt(puzzleSize);
                position[1] = randomizer.nextInt(puzzleSize);

                end_position[0] = position[0] + wordLength * step[0];
                end_position[1] = position[1] + wordLength * step[1];

                if (end_position[0] < 0 || end_position[0] > puzzleSize)
                    continue;
                if (end_position[1] < 0 || end_position[1] > puzzleSize)
                    continue;
                hasFailed = false;

                for (i = 0; i < wordLength; i++) {
                    character = word.charAt(i);

                    new_position[0] = position[0] + i * step[0];
                    new_position[1] = position[1] + i * step[1];

                    characterAtNewPosition = grid[new_position[0]][new_position[1]];

                    if (characterAtNewPosition != '\0') {
                        if (characterAtNewPosition == character)
                            continue;
                        else {
                            hasFailed = true;
                            break;
                        }
                    }
                }

                if (hasFailed)
                    continue;
                else {
                    for (i = 0; i < wordLength; i++) {
                        character = word.charAt(i);

                        new_position[0] = position[0] + i * step[0];
                        new_position[1] = position[1] + i * step[1];

                        grid[new_position[0]][new_position[1]] = character;
                    }

                    isPlaced = true;
                }
            }

        }
        for (int x = 0; x < puzzleSize; x++) {
            for (int y = 0; y < puzzleSize; y++) {
                if (grid[x][y] == '\0') {
                    grid[x][y] = (char) (randomizer.nextInt(26) + 65);
                }
            }
        }

        List<String> puzzleLines = new ArrayList<String>();

        for (char[] line : grid)
            puzzleLines.add(new String(line));
        
        Puzzle puzzle = new Puzzle(puzzleLines, words);
        return puzzle;
    }

}