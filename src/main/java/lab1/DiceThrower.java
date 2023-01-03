package lab1;

import java.util.Random;

public class DiceThrower {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Dice dice = new Dice();
            Counter.getInstance().getNum()[dice.getPoint() - 1] ++;
        }
        System.out.println("Point 1 :" + Counter.getInstance().getNum()[0]);
        System.out.println("Point 2 :" + Counter.getInstance().getNum()[1]);
        System.out.println("Point 3 :" + Counter.getInstance().getNum()[2]);
        System.out.println("Point 4 :" + Counter.getInstance().getNum()[3]);
        System.out.println("Point 5 :" + Counter.getInstance().getNum()[4]);
        System.out.println("Point 6 :" + Counter.getInstance().getNum()[5]);
    }
}

class Dice{
    private final int point;
    Dice(){
        Random r = new Random();
        point = r.nextInt(6) + 1;
    }

    public int getPoint(){
        return point;
    }
}

class Counter{
    private static final Counter counter = new Counter();
    private static final int[] num=new int[6];
    private Counter(){}

    public static Counter getInstance(){
        return counter;
    }

    public int[] getNum(){
        return num;
    }

}
