package lab01;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadData {
    
    public static List<String> read(Scanner input) {
        List<String> data = new ArrayList<String>();

        while (input.hasNext()) {
            data.add(input.next());
        }

        return data;
    }
}
