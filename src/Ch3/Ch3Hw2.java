package Ch3;

public class Ch3Hw2 {
    public static void main(String[] args) {
        int sum=0;
        int count=0;
        for(int i=0;i<=100;i++){
            if(i % 7 == 0){
                sum+=i;
                count++;
            }
        }
    }
}
