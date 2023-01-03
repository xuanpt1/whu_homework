package lab2.pizza;

public class PizzaMain {
    public static void main(String[] args) {
        VegPizza pizza = new VegPizza();
        ChickenDecorator chickenDecorator = new ChickenDecorator(pizza);

        System.out.println(chickenDecorator.getDescription());
    }
}
