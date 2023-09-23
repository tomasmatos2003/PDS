import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Validation {
    public static boolean esMatrizCuadrada(char[][] matriz) {
        int filas = matriz.length;
        if (filas == 0 || filas > 40) {
            return false;
        }
        int columnas = matriz[0].length;
        if (columnas == 0 || columnas > 40) {
            return false;
        }
        if (filas != columnas) {
            return false;
        }
        for (int i = 1; i < filas; i++) {
            if (matriz[i].length != columnas) {
                return false;
            }
        }
        return true;
    }

    private static List<String> parsearLista(String solucion) {
        List<String> elementos;
        if (solucion.contains(",")) {
            elementos = Arrays.asList(solucion.split(","));
        } else if (solucion.contains(";")) {
            elementos = Arrays.asList(solucion.split(";"));
        } else if (solucion.contains(" ")) {
            elementos = Arrays.asList(solucion.split(" "));
        } else {
            //En caso de no ser ninguno de los anteriores, se guarda en la lista
            //como una única palabra y lo desecha la siguiente comprobación
            elementos = Collections.singletonList(solucion);
        }
        return elementos;
    }

    public static boolean validarLista(String palabras) {
        //Comprobar que con tenga los separados "," || ";" || " "
        if (palabras.matches(".*,|.*;|.*\\s.*")) {
            List<String> lista = parsearLista(palabras);
            //Comprobar que haya al menos 3 palabras
            if (lista.size() >= 3) {
                for (String palabra : lista) {
                    //Comprobamos que las palabras estén formadas por letras minusculas
                    //y que la lista no contenga espacios
                    if (!palabra.matches("[a-z]+")) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    public static boolean tieneEspacOMin(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                char c = matriz[i][j];
                if (c == ' ' || Character.isLowerCase(c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
