package lab10.ex1;

import java.util.List;

public abstract class Observador {
    protected String nome;
    private boolean isGestor = this instanceof Gestor;

    public Observador(String nome) {
        this.nome = nome;
    }

    public Observador(String nome, List<Produto> produtos) {
        this.nome = nome;
        for (Produto produto : produtos) {
            produto.adicionarObservador(this);
        }
    }

    public void notificar(Produto produto) {
        System.out.println(this.getClass().getSimpleName() + " " + nome
                + ": O produto " + produto.getDescricao()
                + " está no estado " + produto.getEstado() + " com o preço "
                + produto.getPrecoLeilao() + "€." + " O cliente é " + produto.getCliente() + ".");
    }

    public void consultarProdutos(List<Produto> produtos) {
        System.out.println(this.getClass().getSimpleName() + " " + nome
                + ": A consultar produtos...");
        for (Produto produto : produtos) {
            if (produto.getEstado() == EstadoProduto.LEILAO || this.isGestor)
                System.out.println(produto);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Observador other = (Observador) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
