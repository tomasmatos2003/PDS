package lab07.ex2;

import java.util.Collections;
import java.util.Stack;

public class CapitalizationFilter extends TextFilter {
    private Stack<String> words;

    public CapitalizationFilter(DocumentProcessor processor) {
        super(processor);
        String newWord;
        int i;
        int wordSize;
        this.words = new Stack<>();
        while(this.processor.hasNext()) {
            for (String word : this.processor.next().split(" ")) {
                newWord = "";
                i = 0;
                wordSize = word.length() - 1;
                for (char letter : word.toCharArray()) {
                    if (i == 0 || i == wordSize) {
                        newWord += Character.toUpperCase(letter);
                    }
                    else {
                        newWord += letter;
                    }
                    i++;
                }
                this.words.push(newWord);;
            }
        }
        Collections.reverse(this.words);
    }

    @Override
    public boolean hasNext() {
        return !this.words.empty();
    }

    @Override
    public String next() {
        return words.pop();
    }
}
