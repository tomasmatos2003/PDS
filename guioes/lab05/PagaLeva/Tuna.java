package lab05.PagaLeva;

public class Tuna implements Portion{
    String name;
    Temperature temperature;
    State state;

    public Tuna(String name, Temperature temperature) {
        this.name = name;
        this.temperature = temperature;
        this.state = State.Solid;
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
        return new Tupperware(this);
    }
}
