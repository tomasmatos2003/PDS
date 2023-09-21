package lab10.ex3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aviao TAP1 = new Aviao("TAP1", null);
        Aviao TAP2 = new Aviao("TAP2", null);
        Aviao TAP3 = new Aviao("TAP3", null);
        Aviao TAP4 = new Aviao("TAP4", null);
        Aviao TAP5 = new Aviao("TAP5", null);

        

        TorreServico torre1 = new TorreServico("Paranhos da Beira",new ArrayList<>());
        TorreServico torre2 = new TorreServico("Viseu", new ArrayList<>());

        torre1.adicionar_aviao(TAP1);
        torre1.adicionar_aviao(TAP2);  

        torre2.adicionar_aviao(TAP3);
        torre2.adicionar_aviao(TAP4);

        System.out.println("---- Aviões ----");
        System.out.println(TAP1.toString());
        System.out.println(TAP2.toString());
        System.out.println(TAP3.toString());
        System.out.println(TAP4.toString());
        System.out.println(TAP5.toString());

        System.out.println("---- Torres ----");
        System.out.println(torre1.toString() + ": ");

        for (Aviao aviao : torre1.avioes_Torre) {
            System.out.println("    "+aviao.toString());
        }

        System.out.println(torre2.toString() + ": ");
        for (Aviao aviao : torre2.avioes_Torre) {
            System.out.println("    "+aviao.toString());
        }

        System.out.println("---- Mensagens ----");
        TAP1.manda("Olá TAP2");
        torre1.informar("Olá TAP2", TAP2);
        
    }
}
