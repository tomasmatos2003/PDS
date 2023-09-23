package lab09.ex2;

import java.util.ArrayList;
import java.util.List;

public class OrderDemo {
    public static void main(String[] args) {
        List<String> foods = new ArrayList<String>();
        foods.add("veggie burger");
        foods.add("Pasta Carbonara");
        foods.add("PLAIN pizza, no toppings!");
        foods.add("sushi nigiri and sashimi");
        foods.add("salad with tuna");
        foods.add("strawberry ice cream and waffles dessert");
        Chef chefs = new SushiChef().setNextChef(
                new PastaChef().setNextChef(new BurgerChef().setNextChef(new PizzaChef().setNextChef(new DessertChef()))));
        for (String food : foods) {
            System.out.println("Can I please get a " + food + "?");
            chefs.cook(food);
            System.out.println();
        }
    }
}
