package lab07.ex3;

public abstract class Produto {
    protected String name;
    protected double weight;

    public Produto(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public abstract void draw();

    public String getName() {
        return this.name;
    }

    public double total() {
        return this.weight;
    }
}
