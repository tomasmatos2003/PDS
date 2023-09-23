package lab05.Pastelaria;

public class CakeMaster {

    private CakeBuilder cakeBuilder;

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }

    public void createCake(String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
    }

    public void createCake(int numLayers, String message) {
        this.createCake(message);
        for (int i = 0; i < numLayers - 1; i++)
            cakeBuilder.addCakeLayer();
    }

    public void createCake(Shape shape, int numLayers, String message) {
        this.createCake(numLayers, message);
        cakeBuilder.setCakeShape(shape);
    }
}
