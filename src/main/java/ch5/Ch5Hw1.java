package ch5;

import ch4.Ch4Hw1;

import java.util.Arrays;
import java.util.Scanner;

// 回文
public class Ch5Hw1 {
    public boolean isBackWord(String w){
        char[] w_True = new char[w.length()];
        char[] w_Back = new char[w.length()];
        //
        for(int i=0;i< w.length();i++){
            w_True[i] = w.charAt(i);
        }
        System.out.println("Input: ");
        System.out.println(w_True);
        //
        for(int i=0;i< w.length();i++){
            w_Back[w_Back.length-1-i] = w.charAt(i);
        }
        System.out.println("Back: ");
        System.out.println(w_Back);
        System.out.println("Do Equal:");
        for(int i=0;i< w.length();i++){
            if(w_True[i]!=w_Back[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ch5.Ch5Hw1 hw1 = new Ch5Hw1();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(hw1.isBackWord(word));
    }
}
