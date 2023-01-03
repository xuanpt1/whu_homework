package lab2.pizza;

public class NonVegPizza extends Pizza{
    String description = " NonVegPizza";

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + description;
    }
}
