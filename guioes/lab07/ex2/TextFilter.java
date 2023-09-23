package lab07.ex2;

public abstract class TextFilter implements DocumentProcessor {
    protected DocumentProcessor processor;

    public TextFilter(DocumentProcessor processor) {
        this.processor = processor;
    }
    
    @Override
    public boolean hasNext() {
        return processor.hasNext();
    }

    @Override
    public String next() {
        return processor.next();
    }
}
