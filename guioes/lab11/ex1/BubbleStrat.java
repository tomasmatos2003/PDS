package lab11.ex1;

import java.util.List;

public class BubbleStrat implements Strategy {
  
    @Override
    public void sort(List<Telemovel> telemoveis, String criterio) { //}, Comparable<Telemovel> comp) {
        System.out.println("-- bubble --");
        boolean changed = false;
        do {
            changed = false;
            for (int a = 0; a < telemoveis.size() - 1; a++) {
                String attr1 =  String.valueOf(telemoveis.get(a).get(criterio));
                String attr2 = String.valueOf(telemoveis.get(a + 1).get(criterio));

                
                if (attr1.compareTo(attr2) > 0) {
                    Telemovel tmp = telemoveis.get(a);
                    telemoveis.set(a, telemoveis.get(a + 1));
                    telemoveis.set(a + 1, tmp);
                    changed = true;
                }       
                
            }
        } while (changed);


    }
}