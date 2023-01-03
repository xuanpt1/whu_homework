package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ch4Hw1 {
    public static void main(String[] args) {
        //随手输入的10个2位正整数
        int[] sortInt = {13,94,27,54,87,32,48,91,51,24};
        List<Integer> sortList = new ArrayList<>();
        for (int i : sortInt) {
            sortList.add(i);
        }
        //sort
        Collections.sort(sortList);
        System.out.println(sortList);
        //insert
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        boolean doInsert = false;
        for(int index = 0;index < sortInt.length;index++){
            if(!doInsert && sortList.get(index) >= num){
                sortList.add(index,num);
                doInsert = true;
            }
        }
        if(!doInsert){
            sortList.add(num);
        }
        System.out.println(sortList);

    }
}
