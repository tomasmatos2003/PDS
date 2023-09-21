import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {
    private static boolean valid_final_position(int x_first, int y_first, int x_last, int y_last, int word_size) {
        // for vertical and horizontal
        double res = Math.sqrt(Math.pow(x_last - x_first, 2) + Math.pow(y_last - y_first, 2));   
        // for diagonal too
        return res == word_size-1 || (Math.abs(x_first - x_last) == word_size-1 && Math.abs(y_first - y_last) == word_size-1); 
    }

    private static int get_direction(int first, int last) {
        int dir;
        if (first < last) {
            dir = 1;
        } else if (first > last) {
            dir = -1;
        } else {
            dir = 0;
        }
        return dir;
    }

    private static void printSolvedPuzzle(List<String> puzzle, ArrayList<ArrayList<Integer>> positions) {
        Boolean find = false;
        for (int i = 0; i < puzzle.size(); i++) {
            for (int j = 0; j < puzzle.get(i).length(); j++) {
                for (int k = 0; k < positions.size(); k++) {
                    if (positions.get(k).get(0) == j && positions.get(k).get(1) == i) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    System.out.print(Character.toUpperCase(puzzle.get(i).charAt(j)) + " ");
                    find = false;
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> get_coordinates(ArrayList<ArrayList<Integer>> all_first, ArrayList<ArrayList<Integer>> all_last, String word, List<String> puzzle1) {
        
        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int x_first, y_first, x_last, y_last;
        int x_dir, y_dir;
        
        for(int i=0; i < all_first.size(); i++){
            for( int j=0; j < all_last.size(); j++){
                x_first = all_first.get(i).get(1);
                y_first = all_first.get(i).get(0);
                x_last = all_last.get(j).get(1);
                y_last = all_last.get(j).get(0);
               
                if(valid_final_position(x_first, y_first, x_last, y_last, word.length())){
                    
                   
                    x_dir = get_direction(x_first, x_last);
                    y_dir = get_direction(y_first, y_last);
                      
                    boolean find = true;
                    for( int x = x_first, y = y_first, k = 1; k <= word.length(); x += x_dir, y += y_dir, k += 1){                          

                        if (puzzle1.get(y).charAt(x) != Character.toUpperCase(word.charAt(k-1))) {
                            options = new ArrayList<ArrayList<Integer>>();
                            find = false;
                            break;
                        }   
                        coordinates.add(x);
                        coordinates.add(y);
                        options.add(coordinates);
                        coordinates = new ArrayList<Integer>();                 
                    }
                    
                    if (find) {
                        String str_dirx = "";
                        String str_diry = "";

                        if (x_dir == 1) {
                            str_dirx = "Right";
                        } else if (x_dir == -1) {
                            str_dirx = "Left";
                        }

                        if (y_dir == 1) {
                            str_diry = "Down";
                        } else if (y_dir == -1) {
                            str_diry = "Up";
                        }
                        
                        System.out.printf("%-15s %-5d %-7s %-6s\n", word, word.length(), Integer.toString(y_first + 1) + "," +  Integer.toString(x_first + 1), str_dirx + str_diry);
         
                        return options;
                    }   
                }
               
            }
        }
        return options;
    }

    public static void printSolution(Puzzle wordSearchPuzzle) {

        List<String> puzzle1 = wordSearchPuzzle.getPuzzleGrid();
        List<String> wordList = wordSearchPuzzle.getWordList();


        ArrayList<ArrayList<Integer>> positions = new ArrayList<ArrayList<Integer>>();

        for ( int index= 0; index < wordList.size(); index++) {
        
            
        ArrayList<ArrayList<Integer>> all_first = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> all_last = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> coordinates = new ArrayList<Integer>();

        

        for (int i=0; i < puzzle1.size(); i++) {
            for (int j=0; j < puzzle1.get(i).length(); j++) {
                // first
                if (Character.compare(Character.toLowerCase(puzzle1.get(i).charAt(j)), wordList.get(index).charAt(0)) == 0) {
                 
                    coordinates.add(i);
                    coordinates.add(j);
                    all_first.add(coordinates);
                    //(y ,x)
                    coordinates = new ArrayList<Integer>();

                }
                // last
                else if (Character.compare(Character.toLowerCase(puzzle1.get(i).charAt(j)), wordList.get(index).charAt(wordList.get(index).length() - 1)) == 0){
                 
                    coordinates.add(i);
                    coordinates.add(j);
                    all_last.add(coordinates);
                    //(y ,x)
                    coordinates = new ArrayList<Integer>();
                
                }
            }
        }

        if(wordList.get(index).charAt(0) == wordList.get(index).charAt(wordList.get(index).length() - 1)){
            all_last = all_first;
        }

        options = get_coordinates(all_first, all_last, wordList.get(index), puzzle1);
        positions.addAll(options);

        }
        printSolvedPuzzle(puzzle1, positions);
    }
}
