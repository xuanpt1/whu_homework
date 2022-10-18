package ch3;

import java.util.Scanner;

/*1.使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输出 “other”。*/
public class Ch3Hw4 {
    public static void main(String[] args) {
        System.out.println("请输入一个字母");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        char firstChar=input.charAt(0);
        switch (firstChar){
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
