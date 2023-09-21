public class Ponto implements TipoGeometria {

    private int x;
    private int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto() {
    }

    @Override
    public void draw() {
        if ( !(this instanceof NullPonto)){
            StringBuilder sb = new StringBuilder("Drawing a Point (");
            sb.append("x=" + x);
            sb.append(", y="+ y);
            sb.append(")");
            System.out.println(sb.toString()); 
        }
        
    }

    @Override
    public boolean isValid() {
        if (this.x >= 0 && this.y >= 0){
            return true;
        }else {
            return false;
        }
    }

    public static Ponto create(int x, int y) {

        Ponto p = new Ponto(x, y);
        if (p.isValid()){
            return p;
        } else {
            return new NullPonto();
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}