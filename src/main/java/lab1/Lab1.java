package lab1;

public class Lab1 {
    public static void main(String[] args) {
        new TempClass(8,10);
    }
}

class TempClass {
    TempClass(){
        System.out.println("default");
    }
    TempClass(int x){
        this();
        System.out.println(x);
    }
    TempClass(int x, int y){
        this(5);
        System.out.println(x*y);
    }


}
