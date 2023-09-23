package lab05.Pastelaria;

public class SpongeCakeBuilder extends AbstractCakeBuilder {

    @Override
    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Whipped_Cream);
    }

    @Override
    public void addTopping() {
        this.cake.setTopping(Topping.Fruit);
    }

    @Override
    protected void setCakeType() {
        this.cake.setCakeLayer("Sponge");
    }
}
