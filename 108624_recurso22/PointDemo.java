import java.util.ArrayList;
import java.util.List;

public class PointDemo {
    public static void main(String[] args) {
        System.out.println("Alinea a) ----------------------");
        Ponto p1 = Ponto.create(0, 0);
        Ponto p2 = Ponto.create(0, 4);
        Ponto p3 = Ponto.create(4, 4);
        Ponto p4 = Ponto.create(4, 0);
        Ponto p5 = Ponto.create(2, 6);

        List<Ponto> list1 = new ArrayList<>();
        list1.add(p2);
        list1.add(p3);
        list1.add(p4);
        list1.add(p1);
        list1.add(p2);


        List<Ponto> list2 = new ArrayList<>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);
        list2.add(p4);
        list2.add(p5);


        for (Ponto ponto : list2) {
            ponto.draw();
        }

        Poligno polig1 = Poligno.create(list1);
        polig1.draw();

        Poligno polig2 = Poligno.create(list2);
        polig2.draw();


        System.out.println("Alinea b) ----------------------");
        Geometria geo1 = new Geometria(1);
        geo1.add(p1);
        geo1.add(p2);
        geo1.add(p4);
        geo1.add(polig1);

        geo1.draw();

        Geometria geo2 = new Geometria(2);
        geo2.add(geo1);

        geo2.draw();

        System.out.println("Aliena c) -----------------------");


        Pattern bl = new Pattern(p1, "blue");
        bl.draw();
        

        Pattern gren = new Pattern(p1, "green");
        geo1.draw();

        Transparency t30 = new Transparency(bl, 30.0);  
        t30.draw();

    }   
}
