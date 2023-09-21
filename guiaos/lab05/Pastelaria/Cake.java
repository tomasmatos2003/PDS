package lab05.Pastelaria;

public class Cake {

    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake() {
        this.shape = Shape.Circular;
        this.numCakeLayers = 0;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public void addCakeLayer() {
        this.numCakeLayers++;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder()
            .append(cakeLayer)
            .append(" cake with ")
            .append(String.valueOf(this.numCakeLayers))
            .append(" layers");
        if (midLayerCream != null) {
            output.append(" and ")
                .append(midLayerCream)
                .append(" cream");
        }
        output.append(", topped with ")
            .append(topLayerCream)
            .append(" cream and ")
            .append(topping)
            .append(". Message says: \"")
            .append(this.message)
            .append("\".");
        return output.toString();
    }

}
