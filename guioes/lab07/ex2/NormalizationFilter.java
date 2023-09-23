package lab07.ex2;

import java.text.Normalizer;
import java.util.Collections;
import java.util.Stack;

public class NormalizationFilter extends TextFilter{
    private Stack<String> paragraphs;

    public NormalizationFilter(DocumentProcessor processor) {
        super(processor);
        this.paragraphs = new Stack<>();
        while(this.processor.hasNext()) {
            paragraphs.push(Normalizer.normalize(this.processor.next(), Normalizer.Form.NFKD)
                .replaceAll("\\p{M}", ""));
        }
        Collections.reverse(paragraphs);
    }

    @Override
    public boolean hasNext() {
        return !paragraphs.empty();
    }

    @Override
    public String next() {
        return paragraphs.pop();
    }
}
