package lab07.ex3;

public class Conserva extends Produto {
    public Conserva(String name, int weight) {
        super(name, weight);
    }

    public void draw() {
        System.out.println("Conserva: " + name + " - Weight : " + weight);
    }
}
