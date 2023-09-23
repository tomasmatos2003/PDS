package lab05.PagaLeva;

public class Milk implements Portion{
    String name;
    Temperature temperature;
    State state;

    public Milk(String name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
        this.state = State.Liquid;
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
        return name + ": Temperature " + this.temperature + ", State " + this.state; 
    }

    @Override
    public Container createContainer() {
        return new TermicBottle(this);
    }
}
