package lab11.ex1;

import java.util.ArrayList;
import java.util.List;

public class Revista {
    private String nome;
    private List<Telemovel> telemoveis = new ArrayList<>();
    private Strategy st; 

    public Revista (String nome, ArrayList<Telemovel> telemoveis, Strategy st ) {
        this.nome = nome;
        this.telemoveis = telemoveis;
        this.st = st;
    }

    public void adicionar_tele(Telemovel t){
        telemoveis.add(t);
    }

    public void setSt(Strategy st) {
        this.st = st;
    }

    public Strategy getSt() {
        return st;
    }
    
    public String getNome() {
        return nome;
    }
    public List<Telemovel> getTelemoveis() {
        return telemoveis;
    }
    
}
