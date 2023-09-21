package lab09.ex2;

public class PastaChef extends Chef {
    public PastaChef() {
        super(ChefSpecialty.PASTA, 14);
    }

    @Override
    public void cook(String food) {
        if (canCook(food)) {
            System.out.println(this.getClass().getSimpleName() + ": Starting to cook "
                    + food + ". Out in " + this.minutesToCook + " minutes!");
            
                    fullTime = fullTime + this.minutesToCook;
            System.out.println(fullTime);
        } else {
            System.out.println(this.getClass().getSimpleName() + ": I can't cook that.");
            super.cook(food);
        }

    }
}
