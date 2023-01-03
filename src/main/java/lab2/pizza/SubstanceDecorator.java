package lab2.pizza;

public abstract class SubstanceDecorator extends Pizza {
    private Pizza pizza;

    public SubstanceDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
