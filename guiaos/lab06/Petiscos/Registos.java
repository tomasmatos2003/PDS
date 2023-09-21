package lab06.Petiscos;

import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        // Code to insert employee
        empregados.add(emp);
    }

    public void remove(int codigo) {
        // Code to remove employee
        int i = 0;
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                empregados.remove(i);
                break;
            }
            i++;
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return empregados;
    }
}
