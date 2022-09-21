package ch3;

/*3.输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。*/
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
