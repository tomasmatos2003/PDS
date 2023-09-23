package lab05.Movie;

public class Place {
    private final String name;
    private final int coordenates;
    public Place(String name, int coordenates) {
        this.name = name;
        this.coordenates = coordenates;
    }

    public int getCoordenates() {
        return coordenates;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Place [coordenates=" + coordenates + ", name=" + name + "]";
    }
   
}
