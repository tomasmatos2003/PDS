import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WordSearch {
    private char[][] matriz;
    private List<String> palabras;

    public WordSearch(char[][] matriz, List<String> palabras) {
        this.matriz = matriz;
        this.palabras = palabras;
    }

    public Map<String, WordInfo> searchWords() {
        Map<String, WordInfo> foundWords = new HashMap<String, WordInfo>();
        int size = matriz.length;
        for (String palabra : palabras) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matriz[i][j] == palabra.charAt(0)) {
                        // Check horizontal right
                        if (checkRight(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i, j + palabra.length() - 1),
                                    "Right");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check horizontal left
                        if (checkLeft(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i, j - palabra.length() + 1),
                                    "Left");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check vertical down
                        if (checkDown(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i + palabra.length() - 1, j),
                                    "Down");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check vertical up
                        if (checkUp(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i - palabra.length() + 1, j),
                                    "Up");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check diagonal down-right
                        if (checkDownRight(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i + palabra.length() - 1, j + palabra.length() - 1),
                                    "DownRight");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check diagonal down-left
                        if (checkDownLeft(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i + palabra.length() - 1, j - palabra.length() + 1),
                                    "DownLeft");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check diagonal up-right
                        if (checkUpRight(i, j, palabra)){
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i - palabra.length() + 1, j + palabra.length() - 1),
                                    "UpRight");
                            foundWords.put(palabra, info);
                            break;
                        }
                        // Check diagonal up-left
                        if (checkUpLeft(i, j, palabra)) {
                            WordInfo info = new WordInfo(palabra.length(),
                                    new Position(i, j),
                                    new Position(i - palabra.length() + 1, j - palabra.length() + 1),
                                    "UpLeft");
                            foundWords.put(palabra, info);
                            break;
                        }
                    }
                }
            }
        }
        return foundWords;
    }
    private boolean checkRight(int fila, int colum, String palabra) {
        if (colum + palabra.length() > matriz.length) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila][colum + i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeft(int fila, int colum, String palabra) {
        if (colum - palabra.length() < -1) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila][colum - i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDown(int fila, int colum, String palabra) {
        if (fila + palabra.length() > matriz.length) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila + i][colum] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUp(int fila, int colum, String palabra) {
        if (fila - palabra.length() < -1) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila - i][colum] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDownRight(int fila, int colum, String palabra) {
        if (fila + palabra.length() > matriz.length || colum + palabra.length() > matriz.length) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila + i][colum + i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDownLeft(int fila, int colum, String palabra) {
        if (fila + palabra.length() > matriz.length || colum - palabra.length() < -1) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila + i][colum - i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUpRight(int fila, int colum, String palabra) {
        if (fila - palabra.length() < -1 || colum + palabra.length() > matriz.length) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila - i][colum + i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUpLeft(int fila, int colum, String palabra) {
        if (fila + palabra.length() > matriz.length || colum - palabra.length() < -1) {
            return false;
        }
        for (int i = 0; i < palabra.length(); i++) {
            if (matriz[fila + i][colum - i] != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}