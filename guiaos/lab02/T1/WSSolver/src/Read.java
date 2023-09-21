import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {

    private static char[][] leeMatriz(BufferedReader lector) throws IOException {
        // Lista para almacenar todas las lineas
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = lector.readLine()) != null) {
            lines.add(line);
        }

        // Determinar el tamaño de la matriz
        int numfilas = lines.size() - 1; //Para no tener en cuenta la última línea
        int numCols = 0;
        for (String lineStr : lines) {
            numCols = Math.max(numCols, lineStr.length());
        }

        // Crear la matriz y llenarla
        char[][] matrix = new char[numfilas][numCols];
        for (int fila = 0; fila < numfilas; fila++) {
            String line_ = lines.get(fila);
            for (int colum = 0; colum < line_.length(); colum++) {
                char c = line_.charAt(colum);
                matrix[fila][colum] = c;
            }
        }
        return matrix;
    }

    private static List<String> readLastLine(String fichero) throws IOException {
        // Leer todas las líneas del archivo y obtener la última línea
        String lastLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            System.err.format("Error E/S: " + e);
        }

        // Separar la última línea por comas y almacenar cada elemento en una lista
        List<String> solucion = new ArrayList<>();
        String[] palabras = lastLine.split(";");
        for (String part : palabras) {
            solucion.add(part);
        }

        return solucion;
    }

}
