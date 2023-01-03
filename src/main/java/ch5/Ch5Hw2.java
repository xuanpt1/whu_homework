package ch5;

import java.util.Scanner;


//先输入一个字符ch，再输入一个字符串，在字符串中查找该字符(ch)
public class Ch5Hw2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符ch:");
        char ch = scanner.nextLine().charAt(0);
        System.out.println("输入字符串:");
        String chs = scanner.nextLine();
        scanner.close();

        //index
        int index = -1;
        for(int i = 0;i<chs.length();i++){
            if(chs.charAt(i) == ch){
                index = i;
            }
        }
        if(index >= 0){
            System.out.println("最后出现位置为: "+index);
        }
        else{
            System.out.println("Not Found");
        }
    }
}
