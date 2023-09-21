package lab06.Petiscos;

import java.util.List;

public class RegistosAdapter implements DBInterface {
    private Registos registos = new Registos();

    @Override
    public void insere(Empregado emp) {
        registos.insere(emp);
    }

    @Override
    public void remove(int codigo) {
        registos.remove(codigo);
    }

    @Override
    public boolean isEmpregado(int codigo) {
        return registos.isEmpregado(codigo);
    }

    @Override
    public List<Empregado> listaDeEmpregados() {
        return registos.listaDeEmpregados();
    }
}
