package lab10.ex1;

public class Cliente extends Observador {

    public Cliente(String nome) {
        super(nome);
    }

    public void licitar(Produto produto, double valor) {
        produto.licitacao(this, valor);
    }
}
