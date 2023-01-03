package ch6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 质数
public class Ch6Hw1 {
    public static void main(String[] args) {

        System.out.println("input a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Integer> res = new ArrayList<Integer>();
        if(num <=2){
            System.out.println("不是质数");
            return;
        }
        else{
            for(int i = 2;i< num+1;i++){
                boolean flag = true;
                for(int j = 2;j < i;j++){
                    if(i%j ==0){
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
