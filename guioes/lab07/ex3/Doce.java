package lab07.ex3;

public class Doce extends Produto{
    public Doce(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void draw() {
        System.out.println("Doce: " + name + " - Weight : " + weight);
    }
}