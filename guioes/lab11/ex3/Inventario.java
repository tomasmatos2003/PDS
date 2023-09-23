package lab11.ex3;

public class Inventario implements EstadoLivro {

    @Override
    public void regista(Livro livro) {
        livro.setEstado(new Disponivel());
    }

    @Override
    public void requisita(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public void devolve(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public void reserva(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public void cancelaReserva(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public String toString() {
        return "Inventário";
    }
}
