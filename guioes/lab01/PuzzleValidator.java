import java.util.List;

public abstract class PuzzleValidator {

    private static boolean puzzleMatrixValidation = false;
    private static boolean wordListValidation = false;
    private static boolean lines = false;

    public static boolean validate(List<String> Puzzle, List<String> wordList) {
        puzzleMatrixValidation = validatePuzzleMatrix(Puzzle);
        wordListValidation = validateWords(wordList);
        lines = validateLines(wordList);
        return (puzzleMatrixValidation && wordListValidation && lines);
    }

    private static boolean validatePuzzleMatrix(List<String> Puzzle) {
        int puzzleSize = Puzzle.size();
        int i;
        if (puzzleSize > 40 || puzzleSize < 1)
            return false;
        for (String line : Puzzle) {
            if (puzzleSize != line.length() || line.isBlank())
                return false;
            for (i = 0; i < line.length(); i++) {
                if (!Character.isUpperCase(line.charAt(i)))
                    return false;
            }
        }
        return true;
    }

    private static boolean validateWords(List<String> wordList) {

        int wordLength;
        int upperCaseCount;
        char letter;

        for (String word : wordList) {
            wordLength = word.length();
            if (wordLength < 3 || word.isBlank())
                return false;
            upperCaseCount = 0;
            for (int i = 0; i < wordLength; i++) {
                letter = word.charAt(i);
                if (Character.isUpperCase(letter))
                    upperCaseCount++;
                if (!Character.isUpperCase(letter) && !Character.isLowerCase(letter))
                    return false;
            }
            if (upperCaseCount == wordLength) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateLines(List<String> Lines) {
        for (String line : Lines) {
            if (line.isBlank()) {
                return false;
            }
        }
        return true;
    }
}
