package Ch3;

public class Ch3Hw3 {
    public static void main(String[] args) {
        for(int i=100;i<1000;i++){
            int theHundred=i/100;
            int theUnit=i%10;
            int theDecade=(i-theHundred*100)/10;
            if (theUnit*theUnit*theUnit+theDecade*theDecade*theDecade+theHundred*theHundred*theHundred==i){
                System.out.println(i);
            }
        }
    }
}
