package lab2.pizza;

public class VegPizza extends Pizza{
    String description = " VegPizza";

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + description;
    }
}
