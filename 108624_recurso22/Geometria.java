import java.util.ArrayList;
import java.util.List;

public class Geometria implements TipoGeometria{

    private List<TipoGeometria> geomtrias = new ArrayList<>();
    private int nr;
    protected int boxLevel;

    public Geometria(int nr) {
        this.nr = nr;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Multi-polygon: " + nr + "\n");
        for (TipoGeometria tipoGeometria : geomtrias) {
            System.out.print("\t".repeat(this.boxLevel + 1));
            tipoGeometria.draw();
        }
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    public void add(TipoGeometria geom) {
        if (geom instanceof Geometria){
            ((Geometria) geom).boxLevel += 1;
        }
        geomtrias.add(geom);
    }
    
}
