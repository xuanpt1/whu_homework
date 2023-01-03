package ch4;

import java.util.Arrays;

public class Ch4Hw2 {
    public static void main(String[] args) {
        //分析杨辉三角：每一行数量为该行数index
        int index = 1;
        //每个数字(I,J) I>=J,为(I-1,J-1)+(I-1,J)
        int[] lastLine = {1};
        int[] currentLine ;
        for(;index <= 10;index++){
            System.out.println(Arrays.toString(lastLine));
            currentLine = new int[index +1];
            //首为1
            currentLine[0] = 1;
            //2~i-1
            for(int i = 1; i < index;i ++){
                currentLine[i] = lastLine[i-1]+lastLine[i];
            }
            //尾为1
            currentLine[index] = 1;
            //赋值上一行
            lastLine = currentLine;
        }
    }
}
