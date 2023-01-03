package ch6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//质因数分解
public class Ch6Hw4 {
    public static ArrayList<Integer> minPrime(int num){
        ArrayList<Integer> res = new ArrayList<>();
        if(num <= 2){
            System.out.println("not a primie");
            return null;
        }
        else {
            for(int i = 2;i< num+1;i++){
                boolean flag = true;
                for(int j =2;j<i;j++){
                    if(i%j==0){
                        flag = false;
                        break;
                    }
                }
                if(flag && !res.contains(i)){
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("input a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int num2 = num;
        List<Integer> resx = new ArrayList<>();
        while (num2 >2){
            List<Integer> res1 = minPrime(num2);
            for (Integer i : res1) {
                if(num2%i==0){
                    if(!resx.contains(i)){
                        resx.add(i);
                    }
                    num2 = num2/i;
                    break;
                }
            }
        }
        System.out.printf(num + " = " );
        for(int i =0;i < resx.size()-1;i++){
            System.out.printf(resx.get(i).toString() + " * ");
        }
        System.out.println(resx.get(resx.size()-1));
    }
}
