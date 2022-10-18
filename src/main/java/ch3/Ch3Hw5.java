package ch3;

import java.util.Scanner;

/*2.对学生成绩大于60分的，输出“合格”。低于60分的，输出“不合格”。*/
public class Ch3Hw5 {
    public static void main(String[] args) {
        System.out.println("请输入学生分数");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        if(input<60){
            System.out.println("不合格");
        }else {
            System.out.println("合格");
        }
    }
}
