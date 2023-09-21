package lab07.ex2;

import java.util.Collections;
import java.util.Stack;

public class VowelFilter extends TextFilter {
    private Stack<String> words;

    public VowelFilter(DocumentProcessor processor) {
        super(processor);
        this.words = new Stack<>();
        while(this.processor.hasNext()) {
            for (String word : this.processor.next().split(" ")) {
                this.words.push(word.replaceAll("[aeiouAEIOU]", ""));
            }
        }
        Collections.reverse(words);
    }

    @Override
    public boolean hasNext() {
        return !words.empty();
    }

    @Override
    public String next() {
        return words.pop();
    }
}
