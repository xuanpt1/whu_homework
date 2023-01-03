package lab1;

public class LazyBin {
    private LazyBin(){}
    private static LazyBin lazyBin = null;
    public static  LazyBin getInstance(){
        if(lazyBin == null){
            lazyBin = new LazyBin();
        }
        return lazyBin;
    }
}
