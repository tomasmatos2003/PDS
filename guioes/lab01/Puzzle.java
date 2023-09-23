import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    
    private List<String> puzzleMatrix;
    private List<String> wordList;

    public Puzzle(List<String> puzzleMatrix, List<String> wordLine) throws IllegalArgumentException {
        
        List<String> wordList = Puzzle.wordLineSplitter(wordLine);
        
        if (PuzzleValidator.validate(puzzleMatrix, wordList) == false)
            throw new IllegalArgumentException("Puzzle is not valid!");
        
        this.wordList = new ArrayList<>();
        for (String word : wordList)
            this.wordList.add(word.toLowerCase());
        this.puzzleMatrix = puzzleMatrix;
    }

    public List<String> getPuzzleGrid() {
        return puzzleMatrix;
    }

    public List<String> getWordList() {
        return wordList;
    }

    @Override
    public String toString() {

        int i;
        String output = "";

        for (String line : puzzleMatrix) {
            for (i = 0; i < line.length(); i++) {
                output += line.charAt(i);
            }
            output += "\n";
        }

        for (String word : wordList) {
            output += word + "\n";
        }

        return output;
    }
    
    public static List<String> wordLineSplitter (List<String> wordLine) {
        boolean canBeAdded = true;
        String words[];
        List<String> wordList = new ArrayList<>();

        for (String line : wordLine) {
            words = line.split("[, .;]");
            for (String word : words) {
                if (!wordList.isEmpty()) {
                    for (String wordInList : wordList) {

                        if (word.startsWith(wordInList)) {
                            wordList.remove(wordInList);
                            break;
                        }
    
                        if (wordInList.toUpperCase().startsWith(word)) {
                            canBeAdded = false;
                            break;
                        }
                    }
                }
                
                if (canBeAdded)
                    wordList.add(word);
            }
        }
        return wordList;
    }
}
