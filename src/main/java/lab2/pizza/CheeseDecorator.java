package lab2.pizza;

public class CheeseDecorator extends SubstanceDecorator{
    String description = " With Cheese";

    public CheeseDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public int getCost() {
        return super.getCost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + description;
    }
}
