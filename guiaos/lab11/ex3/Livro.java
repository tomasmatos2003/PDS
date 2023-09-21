package lab11.ex3;

public class Livro {
    private String titulo;
    private String ISBN;
    private String primeiroAutor;
    private int ano;
    private EstadoLivro estado;

    public Livro(String titulo, String ISBN, String primeiroAutor, int ano) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.primeiroAutor = primeiroAutor;
        this.ano = ano;
        this.estado = new Inventario();
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public void regista() {
        this.estado.regista(this);
    }
    
    public void requisita() {
        this.estado.requisita(this);
    }

    public void devolve() {
        this.estado.devolve(this);
    }

    public void reserva() {
        this.estado.reserva(this);
    }

    public void cancelaReserva() {
        this.estado.cancelaReserva(this);
    }

    public boolean disponivel() {
        return this.estado instanceof Disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getPrimeiroAutor() {
        return primeiroAutor;
    }

    public void setPrimeiroAutor(String primeiroAutor) {
        this.primeiroAutor = primeiroAutor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public EstadoLivro getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", ISBN=" + ISBN + ", primeiroAutor=" + primeiroAutor + ", ano=" + ano
                + ", estado=" + estado + "]";
    }
}
