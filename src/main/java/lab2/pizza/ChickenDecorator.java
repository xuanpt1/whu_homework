package lab2.pizza;

public class ChickenDecorator extends SubstanceDecorator{
    String description = " With Chicken";

    public ChickenDecorator(Pizza pizza){
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
