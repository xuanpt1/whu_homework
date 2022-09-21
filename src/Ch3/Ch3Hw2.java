package Ch3;

public class Ch3Hw2 {
    public static void main(String[] args) {
        int sum=0;
        int count=0;
        for(int number=0;number<=100;number++){
            if(number % 7 == 0){
                sum+=number;
                count++;
            }
        }
    }
}
