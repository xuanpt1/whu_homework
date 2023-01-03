package ch5;

import java.util.Scanner;


// 将十六进制数转换成十进制数
public class Ch5Hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入16进制数:");
        String num16 = scanner.nextLine();
        scanner.close();
        int num10 = 0;
        for(int i = 0; i<num16.length();i++){
            int num = 0;
            switch (num16.charAt(i)){
                case '0' :
                    break;
                case '1':
                    num =1;
                    break;
                case '2':
                    num =2;
                    break;
                case '3':
                    num =3;
                    break;
                case '4':
                    num = 4;
                    break;
                case '5':
                    num = 5;
                    break;
                case '6':
                    num = 6;
                    break;
                case '7':
                    num= 7 ;
                    break;
                case '8':
                    num = 8;
                    break;
                case '9':
                    num = 9;
                    break;
                case 'a':
                    num = 10;
                    break;
                case 'b':
                    num = 11;
                    break;
                case 'c':
                    num = 12;
                    break;
                case 'd':
                    num = 13;
                    break;
                case 'e':
                    num = 14;
                    break;
                case 'f':
                    num = 15;
                    break;
                default:
                    num =0;
            }
            num10 += num * Math.pow(16,num16.length()-i-1);

        }
        System.out.println("十进制数为: "+num10);
    }
}
