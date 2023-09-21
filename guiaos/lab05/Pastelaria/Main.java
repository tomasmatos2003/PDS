package lab05.Pastelaria;

public class Main {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder cholocate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(cholocate);
        cakeMaster.createCake("Congratulations");               // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");                   // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        cakeMaster.setCakeBuilder(cholocate);
        cakeMaster.createCake(7, "Big chocolate cake");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Rectangular, 4, "Big spongy cake");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake("One-layered yogurt cake");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

    }
}
