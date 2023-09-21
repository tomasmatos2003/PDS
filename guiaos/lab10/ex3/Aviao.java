package lab10.ex3;

public class Aviao {
    String nome;
    TorreServico torre;

    public Aviao(String nome, TorreServico torre){
        this.nome = nome;
        this.torre = torre;
    }

    public void manda(String msg){
        System.out.println("Mensagem enviada para a torre (" + this.torre.nome +"): " + msg );
    }

    public void recebe(){
        System.out.println("Mensagem recebida da torre: " + this.torre);
    }

    @Override
    public String toString() {
        if (this.torre != null)
            return "Avião: " + this.nome + " na torre: " + this.torre.nome;
        else
            return "Avião: " + this.nome + " sem torre ";
    }

}
