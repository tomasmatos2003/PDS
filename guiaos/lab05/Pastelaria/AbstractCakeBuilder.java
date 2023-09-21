package lab05.Pastelaria;

public abstract class AbstractCakeBuilder implements CakeBuilder {

    protected Cake cake;
    
    public abstract void addCreamLayer();
    public abstract void addTopLayer();
    public abstract void addTopping();
    protected abstract void setCakeType();

    @Override
    public void addMessage(String m) {
        cake.setMessage(m);
    }

    @Override
    public void createCake() {
        cake = new Cake();
        this.setCakeType();
        this.addCakeLayer();
        this.addTopLayer();
        this.addTopping();
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        if (this.cake.getNumCakeLayers() == 1)
            this.addCreamLayer();
        this.cake.addCakeLayer();
    }
}
