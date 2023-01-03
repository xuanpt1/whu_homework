package lab2.io;

import java.io.IOException;
import java.util.Scanner;

public class SWOSMain {
    public static void main(String[] args) throws IOException {
        System.out.println("输入字符串: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();;
        byte[] b = s.getBytes();

        System.out.println("去除空格后的字符串为： ");
        SkipWhitespaceOutputStream skipWhitespaceOutputStream = new SkipWhitespaceOutputStream(System.out);
        skipWhitespaceOutputStream.write(b);
        skipWhitespaceOutputStream.close();
    }
}
