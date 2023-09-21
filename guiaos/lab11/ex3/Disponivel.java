package lab11.ex3;

public class Disponivel implements EstadoLivro {

    @Override
    public void regista(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public void requisita(Livro livro) {
        livro.setEstado(new Emprestado());
    }

    @Override
    public void devolve(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public void reserva(Livro livro) {
        livro.setEstado(new Reservado());
    }

    @Override
    public void cancelaReserva(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");
    }

    @Override
    public String toString() {
        return "Disponível";
    }
}
