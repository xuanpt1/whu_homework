package ch3;

/*2.打印1~100之间所有是7的倍数的整数的个数及 总和（体会设置计数器的思想）*/
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
