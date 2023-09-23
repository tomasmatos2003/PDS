package lab10.ex1;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Produto {
    private static int codigos = 1;

    private int codigo;
    private String descricao;
    private double precoBase;
    private EstadoProduto estado;
    private Set<Observador> observadores;
    private double precoLeilao;
    private Cliente cliente;

    public Produto(String descricao, double precoBase) {
        this.codigo = Produto.codigos++;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.estado = EstadoProduto.STOCK;
        this.observadores = new HashSet<>();
        this.precoLeilao = precoBase;
        this.cliente = null;
    }

    public void leiloar(int tempo) {
        if (this.estado != EstadoProduto.STOCK)
            return;
        this.estado = EstadoProduto.LEILAO;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                if (cliente != null)
                    estado = EstadoProduto.VENDAS;
                else
                    estado = EstadoProduto.STOCK;
                notificarObservadores();
                timer.cancel();
            }
        }, tempo * 1000);
    }

    public void licitacao(Cliente cliente, double valor) {
        if (this.estado == EstadoProduto.LEILAO) {
            this.adicionarObservador(cliente);
            if (valor > this.precoLeilao) {
                this.precoLeilao = valor;
                this.cliente = cliente;
            }
            this.notificarObservadores();
        }
    }

    public void adicionarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Observador observador : observadores)
            observador.notificar(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public EstadoProduto getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecoLeilao() {
        return precoLeilao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
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
        Produto other = (Produto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto " + this.codigo + ": " + this.descricao + " - "
                + this.estado + " - " + this.precoLeilao + " - Cliente: " + this.cliente;
    }
}
