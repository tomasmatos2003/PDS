package lab05.PagaLeva;

public abstract class Container{
    
    public static Container create(Portion portion) {
        // if (portion.getState() == State.Liquid && portion.getTemperature() == Temperature.COLD) {
        //     return new PlasticBottle(portion);

        // } else if (portion.getState() == State.Solid && portion.getTemperature() == Temperature.WARM) {
        //     return new Tupperware(portion);

        // } else if (portion.getState() == State.Liquid && portion.getTemperature() == Temperature.WARM) {
        //     return new TermicBottle(portion);

        // } else if (portion.getState() == State.Solid && portion.getTemperature() == Temperature.COLD) {
        //     return new PlasticBag(portion);
        // }

        // return null;
        return portion.createContainer();
    }
   
}
