
public class NullGeo implements TipoGeometria{

    @Override
    public void draw() {
        System.out.println("Não dá para desenhar");
    }

    @Override
    public boolean isValid() {
        System.out.println("Não é válido");
        return false;
    }

    @Override
    public String toString() {
        return "Não existe tal geometria";
    }



}
