package Ch3;

public class Ch3Hw1 {
    public static void main(String[] args) {
        int sumOfOdd=0;
        for(int i=0;i<=100;i++){
            if(i%2!=0){sumOfOdd+=i;}
        }
        System.out.println("The Sum Of Odd Of 1 to 100 is "+sumOfOdd);
    }
}
