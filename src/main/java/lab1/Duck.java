package lab1;

public class Duck extends Animal {
    int size;
    public Duck(int newSize){
        size = newSize;
    }

    public Duck(int newSize,String theName){
        super(theName);
        size = newSize;
    }

}