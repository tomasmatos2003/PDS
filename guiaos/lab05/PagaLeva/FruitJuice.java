package lab05.PagaLeva;

public class FruitJuice implements Portion{
    String name;
    Temperature temperature;
    State state;
    
    //predifined fruits
    String Fruit_name = "Orange";

    public FruitJuice(String name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
        this.state = State.Liquid;
    }

    public FruitJuice(String name, Temperature temperature, String Fruit_name) {
        this.name = name;
        this.temperature = temperature;
        this.state = State.Liquid;
        this.Fruit_name = Fruit_name;
    }


    @Override
    public Temperature getTemperature() {
        return this.temperature;
    }

    @Override
    public State getState() {
        return this.state;
    }

    public String toString()
    {   
        return name + ": " + this.Fruit_name + ", Temperature " + this.temperature + ", State " + this.state;
    }

    @Override
    public Container createContainer() {
        return new PlasticBottle(this);
    }
}
