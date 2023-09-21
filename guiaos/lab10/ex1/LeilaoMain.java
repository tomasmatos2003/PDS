package lab10.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LeilaoMain {
    public static void main(String[] args) {
        // Criar gestor
        Gestor gestor = new Gestor("Gestor1");

        // Criar clientes
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");
        Cliente cliente3 = new Cliente("Cliente3");

        // Criar produtos
        Produto produto1 = new Produto("Produto1", 100);
        Produto produto2 = new Produto("Produto2", 200);
        Produto produto3 = new Produto("Produto3", 300);
        Produto produto4 = new Produto("Produto4", 400);
        Produto produto5 = new Produto("Produto5", 500);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);

        // Adicionar produtos ao gestor
        gestor.adicionarProduto(produto1);
        gestor.adicionarProduto(produto2);
        gestor.adicionarProduto(produto3);
        gestor.adicionarProduto(produto4);
        gestor.adicionarProduto(produto5);
        gestor.consultarProdutos(produtos);
        System.out.println();

        produto1.leiloar(2);
        produto2.leiloar(1);
        produto3.leiloar(2);
        cliente1.consultarProdutos(produtos);
        produto4.leiloar(3);
        produto5.leiloar(1);

        System.out.println();

        // Licitacao inicial
        cliente1.licitar(produto1, 150);
        cliente2.licitar(produto1, 120); // Não é aceite porque valor é inferior ao valor atual
        cliente3.licitar(produto2, 205);
        cliente1.licitar(produto2, 250);
        cliente1.licitar(produto3, 310);
        cliente2.licitar(produto4, 420);
        cliente3.licitar(produto1, 200);
        cliente2.licitar(produto1, 200); // Não é aceite porque valor é igual ao valor atual

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println();
                gestor.consultarProdutos(produtos);
                timer.cancel();
                cliente1.licitar(produto5, 600); // Não deve ser aceite porque o produto ja não está em leilão
            }
        }, 3 * 1000);

    }
}
