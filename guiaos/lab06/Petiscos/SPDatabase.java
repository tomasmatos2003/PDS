package lab06.Petiscos;

import java.util.ArrayList;
import java.util.List;

public class SPDatabase implements DBInterface {
    private DBInterface[] db;
    
    public SPDatabase(DBInterface[] db) {
        this.db = db;
    }

    @Override
    public void insere(Empregado emp) {
        db[0].insere(emp);
    }

    @Override
    public void remove(int codigo) {
        for (DBInterface dbInterface : db) {
            dbInterface.remove(codigo);
        }
    }

    @Override
    public boolean isEmpregado(int codigo) {
        for (DBInterface dbInterface : db) {
            if (dbInterface.isEmpregado(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Empregado> listaDeEmpregados() {
        List<Empregado> listaCompleta = new ArrayList<>();
        for (DBInterface dbInterface : db) {
            listaCompleta.addAll(dbInterface.listaDeEmpregados());
        }
        return listaCompleta;
    }
}
