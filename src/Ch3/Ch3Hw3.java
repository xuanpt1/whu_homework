package Ch3;

public class Ch3Hw3 {
    public static void main(String[] args) {
        for(int number=100;number<1000;number++){
            int theHundred=number/100;
            int theUnit=number%10;
            int theDecade=(number-theHundred*100)/10;
            if (theUnit*theUnit*theUnit+theDecade*theDecade*theDecade+theHundred*theHundred*theHundred==number){
                System.out.println(number);
            }
        }
    }
}
