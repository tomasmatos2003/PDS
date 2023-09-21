package lab05.PagaLeva;

public abstract class PortionFactory {
    
    public static Portion create(String type, Temperature temperature) {
        
        if (type.equals("Beverage") && temperature == Temperature.COLD) {
            return new FruitJuice("FruitJuice", temperature);

        } else if (type.equals("Beverage") && temperature == Temperature.WARM) {
            return new Milk("Milk", temperature);

        } else if (type.equals("Meat") && temperature == Temperature.COLD) {
            return new Tuna("Tuna", temperature);

        } else if (type.equals("Meat") && temperature == Temperature.WARM) {
            return new Pork("Pork", temperature);
        }

        return null;
    }

    public abstract Container createContainer();
}
