package ch6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 质数2
public class Ch6Hw2 {
    public static void main(String[] args) {

        System.out.println("input a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Integer> res = new ArrayList<>();
        if(num <=2){
            System.out.println("不是质数");
            return;
        }
        else{
            res.add(2);
            for(int i =2;i< num+1;i++){
                boolean flag = true;
                //System.out.println(Math.sqrt(i));
                for(int j = 2;j< Math.sqrt(i)+1;j++){
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
        System.out.println(num + " 之内有 "+res.size()+" 个质数");
        System.out.println(res);
    }
}
