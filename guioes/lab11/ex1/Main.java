package lab11.ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MergeStrat merge = new MergeStrat();
        BubbleStrat bubble = new BubbleStrat();

        Revista r = new Revista("Bola", new ArrayList<>(), null);
        r.adicionar_tele(new Telemovel("Nokia", 10, 10, 24));
        r.adicionar_tele(new Telemovel("Samsung", 200, 90, 30));
        r.adicionar_tele(new Telemovel("Iphone", 1, 1, 10));
        r.adicionar_tele(new Telemovel("Huawei", 500, 50, 2));
        r.adicionar_tele(new Telemovel("Xiaomi", 300, 30, 5));
        r.adicionar_tele(new Telemovel("A", 400, 40, 3));
        
       
        r.setSt(merge);
        merge.sort(r.getTelemoveis(), "preco");
        for (Telemovel t : r.getTelemoveis()) {
            System.out.println(t);
            
        }

        
        r.setSt(bubble);
        bubble.sort(r.getTelemoveis(), "memoria");
        for (Telemovel t : r.getTelemoveis()) {
            System.out.println(t);
            
        }

        
    }
}
