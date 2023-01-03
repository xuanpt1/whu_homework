package lab2.pizza;

public abstract class Pizza {
    // it is an abstract pizza
    String description = "Unknown Pizza";
    // describe all the ingredients of the Pizza
    public String getDescription()
    { return description; }
    // return price of the pizza, including the base and toppings
    public abstract int getCost();

}
