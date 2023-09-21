package lab07.ex3;

public class Bebida extends Produto {
    public Bebida(String name, int weight) {
        super(name, weight);
    }

    public void draw() {
        System.out.println("Bebida: " + this.name + " - Weight : " + this.weight);
    }
}
