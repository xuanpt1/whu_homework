package lab1;

public class HungerBin {
    private static final HungerBin hungerBin = new HungerBin();
    private HungerBin(){}
    public static HungerBin getInstance(){
        return hungerBin;
    }
}
