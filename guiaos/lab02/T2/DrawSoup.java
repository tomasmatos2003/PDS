package lab01;
import java.util.Random;

public class DrawSoup {

    public static char[][] PlaceWordInSoup(String word,char[][] soup, int size) {
        int chosenDirection = -1;
        int[] position = new int[2];

        while (chosenDirection == -1) {
            position = RandomGenerator.GenerateRandomPosition(word, size, soup);
            chosenDirection = RandomGenerator.GenerateRandomDirection(word, position, soup);
            // places the word in the soup in the given position and direction
        }
        
        int[] dirsRowCol = Validate.checkDirection(chosenDirection);
        int rowDir, colDir;

        rowDir = dirsRowCol[0]; colDir = dirsRowCol[1];

        for(int i=0; i < word.length(); i++) {
            soup[position[0]+rowDir*i][position[1]+colDir*i] = Character.toUpperCase(word.charAt(i));
        }

        return soup;
    }

    public static  char[][]  FillBlankSpaces(char[][] soup){
        Random r = new Random();
        // fills the blank spaces in the soup with random letters
        for (int i=0;i<soup.length;i++){
            for (int j=0;j<soup[0].length;j++){ 
                if (soup[i][j] == '\0'){
                    soup[i][j] = (char) Character.toUpperCase((r.nextInt(26) + 'a'));
                }
            }
        }
        return soup;
    }
}
