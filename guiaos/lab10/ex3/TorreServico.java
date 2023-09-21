package lab10.ex3;

import java.util.ArrayList;
import java.util.List;

public class TorreServico implements TorreInterface {
    String nome;
    List<Aviao> avioes_Torre = new ArrayList<>();

    public TorreServico(String nome, List<Aviao> avioes_Torre){
        this.nome = nome;
        this.avioes_Torre = avioes_Torre;
    }

    public void adicionar_aviao(Aviao a){
        a.torre = this;
        this.avioes_Torre.add(a);
        
    }

    @Override
    public void informar(String msg, Aviao a) {
        System.out.println("Mensagem para " + a.toString() + " : " + msg);
    }

    @Override
    public void receber_info(String msg) {
        System.out.println("Mensagem recebida: " + msg);
    }

    @Override
    public String toString() {
        return "TorreServico: " + this.nome + " com " + this.avioes_Torre.size() + " avioes";
    }
    
}
