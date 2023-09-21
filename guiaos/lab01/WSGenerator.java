import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WSGenerator {
    public static void main(String[] args) {

        int puzzleSize = 0;
        String inputFileName = "";
        String outputFileName = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                switch (args[i]) {
                    case "-i":
                        inputFileName = args[i + 1];
                        break;
                    case "-s":
                        puzzleSize = Integer.parseInt(args[i + 1]);
                        if (puzzleSize > 40) {
                            System.out.println("Puzzle can't be larger than 40x40!");
                            System.exit(1);
                        } else if (puzzleSize < 3) {
                            System.out.println("Puzzle can't be smaller than 3x3!");
                            System.exit(1);
                        }
                        break;
                    case "-o":
                        outputFileName = args[i + 1];
                        break;
                    default:
                        System.out.println(
                                "Invalid options! Usage:\n\tjava WSGenerator -i \"inputFileName.txt\" -s \"sizeOfPuzzle\" -o \"outputFileName.txt\"");
                        System.exit(2);
                }
            }
        }

        File inputFile = new File(inputFileName);
        List<String> wordLines = new ArrayList<String>();
        try (Scanner sc = new Scanner(inputFile)) {
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                wordLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Input file not found!");
            System.exit(3);
        } catch (Exception e) {
            System.out.println("Couldn't open input file.");
            System.exit(4);
        }

        List<String> words = Puzzle.wordLineSplitter(wordLines);
        if (words.isEmpty()) {
            System.out.println("There are no words in the list!");
            System.exit(5);
        }

        int maxWordLength = 0;
        int wordLength = 0;
        for (String word : words) {
            wordLength = word.length();
            if (wordLength > maxWordLength) {
                maxWordLength = wordLength;
            }
        }
        if (maxWordLength > puzzleSize) {
            System.out.println(
                    "Puzzle can't have a smaller size than the longest word! Longest word size = " + maxWordLength);
            System.exit(6);
        }
        
        Puzzle puzzle = PuzzleGenerator.generate(words,puzzleSize);
        String puzzleDetails = puzzle.toString();

        if (outputFileName.isEmpty())
            System.out.println(puzzleDetails);
        else {
            File outputFile = new File(outputFileName);
            try (FileWriter outputFileWriter = new FileWriter(outputFile)) {
                outputFileWriter.write(puzzleDetails);
            } catch (Exception e) {
                System.out.println("Error writing to the output file!");
                System.exit(7);
            }
        }
    }
}