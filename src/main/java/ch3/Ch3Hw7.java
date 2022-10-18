package ch3;

import java.util.Scanner;

/*4. 编写程序：从键盘上输入2014年的“month”和“day”，要求通过程序输出输入的日期为2014年的第几天。*/
public class Ch3Hw7 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        System.out.println("请输入日期");
        int day = scanner.nextInt();
        int sumOfDays=0;
        scanner.close();
        while (month>1&&month<=12){
            month--;
            int daysOfMonth;
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysOfMonth=31;
                    break;
                case 2:
                    daysOfMonth=28;
                    break;
                default:
                    daysOfMonth=30;
                    break;
            }
            sumOfDays+= daysOfMonth;
        }
        sumOfDays+= day;
        System.out.println("此日期为2014年的第 "+sumOfDays+" 天。");
    }
}
