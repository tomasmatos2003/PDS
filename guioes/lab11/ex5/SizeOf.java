package lab11.ex5;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class SizeOf {
    public static void main(String[] args) {
        AtomicLong size = new AtomicLong(0);
        AtomicBoolean recursive = new AtomicBoolean(false);
        Path start;
        if (args.length == 1) {
            start = Paths.get(args[0]);
        } else if (args.length == 2 && args[0].equals("-r")) {
            recursive.set(true);
            start = Paths.get(args[1]);
        } else {
            System.exit(1);
            return;
        }

        try {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    if (file.equals(start) || recursive.get() == true) {
                        return FileVisitResult.CONTINUE;
                    } else
                        return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    int currentDepth = start.relativize(file).getNameCount() - 1;

                    System.out.println("|->".repeat(currentDepth) + file.getFileName() + " "
                            + (long) attrs.size() / 1024 + " kB");
                    size.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Total: " + (long) size.get() / 1024 + " kB");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
