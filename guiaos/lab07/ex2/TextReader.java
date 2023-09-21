package lab07.ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Stack;

public class TextReader implements DocumentProcessor {
    private Stack<String> paragraphs;

    public TextReader(String filePath) throws IOException {
        if(!Files.probeContentType(Path.of(filePath)).equals("text/plain"))
            throw new IOException("File is not a text file");
        paragraphs = new Stack<>();
        this.paragraphs.addAll(Files.readAllLines(Paths.get(filePath)));
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
