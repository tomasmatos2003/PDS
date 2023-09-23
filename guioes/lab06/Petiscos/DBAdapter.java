package lab06.Petiscos;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter implements DBInterface {

    private Database db = new Database();

    public void insere(Empregado emp) {
        // Code to insert employee
        Employee e = new Employee(emp.nome(), emp.codigo(), emp.salario());
        this.db.addEmployee(e);
    }

    public void remove(int codigo) {
        // Code to remove employee
        for (Employee emp : this.db.getAllEmployees()) {
            if (((int) emp.getEmpNum())  == codigo) {
                this.db.deleteEmployee((long) codigo);;
                break;
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (Employee emp : this.db.getAllEmployees()) {
            if (((int) emp.getEmpNum()) == codigo) {
                return true;
            }
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        List<Empregado> empregados = new ArrayList<>();
        for (Employee emp : this.db.getAllEmployees()) {
            empregados.add(new Empregado(emp.getName(), "", (int) emp.getEmpNum(), emp.getSalary()));
        }
        return empregados;
    }
}
