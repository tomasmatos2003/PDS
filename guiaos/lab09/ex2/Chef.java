package lab09.ex2;

public abstract class Chef {
    private Chef nextChef = null;
    protected ChefSpecialty specialty;
    protected int minutesToCook;
    public static int fullTime;

    public Chef(ChefSpecialty specialty, int minutesToCook) {
        this.specialty = specialty;
        this.minutesToCook = minutesToCook;
    }

    public void cook(String food) {
        if (nextChef != null) {
            nextChef.cook(food);
        } else
            System.out.println("We're sorry but that request can't be satisfied by our service!");

    }

    protected boolean canCook(String food) {
        return (food == null) || (food.toLowerCase().contains(specialty.toString().toLowerCase()));
    }

    public Chef setNextChef(Chef nextChef) {
        this.nextChef = nextChef;
        return this;
    }
}