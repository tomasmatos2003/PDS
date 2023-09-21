package lab07.ex2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DocumentProcessor reader;
        reader = new TextReader("lab07/ex2/Text.txt");
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();

        System.out.println("TermFilter:\n");
        reader = new TermFilter(new TextReader("lab07/ex2/Text.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();

        System.out.println("NormalizationFilter:\n");
        reader = new NormalizationFilter(
                new TermFilter(
                        new TextReader("lab07/ex2/Text.txt")));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();

        System.out.println("VowelFilter:\n");
        reader = new VowelFilter(
                new NormalizationFilter(
                        new TermFilter(
                                new TextReader("lab07/ex2/Text.txt"))));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();

        System.out.println("CapitalizationFilter:\n");
        reader = new CapitalizationFilter(
                    new VowelFilter(
                        new NormalizationFilter(
                            new TermFilter(
                                new TextReader("lab07/ex2/Text.txt")))));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
