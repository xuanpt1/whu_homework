package Ch3;

public class Ch3Hw1 {
    public static void main(String[] args) {
        int sumOfOdd=0;
        for(int number=0;number<=100;number++){
            if(number%2!=0){sumOfOdd+=number;}
        }
        System.out.println("The Sum Of Odd Of 1 to 100 is "+sumOfOdd);
    }
}