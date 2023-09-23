package lab10.ex1;

import java.util.List;

public class Gestor extends Observador {
    public Gestor(String nome) {
        super(nome);
    }

    public Gestor(String nome, List<Produto> produtos) {
        super(nome, produtos);
    }

    public void adicionarProduto(Produto produto) {
        produto.adicionarObservador(this);
    }
}
