package lab05.Pastelaria;

public class YogurtCakeBuilder extends AbstractCakeBuilder {

    @Override
    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        this.cake.setTopping(Topping.Chocolate);
    }

    @Override
    protected void setCakeType() {
        this.cake.setCakeLayer("Yogurt");
    }
}
