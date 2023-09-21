package lab09.ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class Teste {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<>();

        vector.addElem("ze");
        vector.addElem("ric");
        vector.addElem("tha");
        vector.addElem("fazers");

        assert vector.totalElem() == 3;
        assert vector.getElem(0).equals("ze");
        assert vector.getElem(1).equals("ric");
        assert vector.getElem(2).equals("tha");
        assert vector.getElem(3).equals("fazers");

        System.out.println("    Iterator");

        Iterator<String> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("    List Iterator");

        ListIterator<String> lt = vector.listIterator();
        while (lt.hasNext()) {
            String next = lt.next();
            System.out.println(next);
            assert next.equals("ze") || next.equals("ric") || next.equals("tha") || next.equals("fazers");
        }

    }
}
