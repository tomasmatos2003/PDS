import java.util.ArrayList;
import java.util.List;

public class Poligno implements TipoGeometria {
    List<Ponto> poligno = new ArrayList<>();

    public Poligno(List<Ponto> poligno) {
        this.poligno = poligno;
    }

    public Poligno() {
    }

    @Override
    public void draw() {
        if ( !(this instanceof NullPolign)) {
            StringBuilder sb = new StringBuilder("Drawing a polygon with points: ");

            for (Ponto ponto : poligno) {
                sb.append("(Point (x=" + ponto.getX() + ", y=" + ponto.getY() + ")) ");
            }

            sb.append(")");
            System.out.println(sb.toString()); 
        }
        
    }

    @Override
    public boolean isValid() {
        if (this.poligno.size() < 4){
            // System.err.println("Tamanho tem que ser 4 ou mais");
            System.out.println(this.getClass().getName() + " is null");
            return false;
        }

        Ponto prim = this.poligno.get(0);
        Ponto ulti = this.poligno.get(this.poligno.size()-1);

        if (prim.getX() == ulti.getX() && prim.getY() == ulti.getY()){
            return true;
        }else {
            // System.out.println("Pontos final e inical são diferentes");
            System.out.println(this.getClass().getName() + " is null");
            return false;
        }
        
        
    }

    public static Poligno create(List<Ponto> p) {
        Poligno p1 = new Poligno(p);
        if (p1.isValid()){
            return new Poligno(p);
        } else {
            return new NullPolign();
        }
        
    }

}
