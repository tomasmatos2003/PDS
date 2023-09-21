package lab07.ex3;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Produto {
    private List<Produto> products = new ArrayList<>();
    protected int boxLevel;

    public Caixa(String name, int weight) {
        super(name, weight);
        boxLevel = 0;
    }

    public void add(Produto product) {
        if (product instanceof Caixa) {
            ((Caixa) product).boxLevel += 1;
        }
        products.add(product);
    }

    @Override
    public double total() {
        double totalWeight = this.weight;
        for (Produto product : this.products) {
            totalWeight += product.total();
        }
        return totalWeight;
    }
    @Override
    public void draw() {
        System.out.println("* Caixa: " + this.name + " [ Weight : " + this.weight +
                 " ; Total : " + this.total() + "]");

        for (Produto product : this.products) {
            System.out.print("\t".repeat(this.boxLevel + 1));
            product.draw();
        }
    }

}
