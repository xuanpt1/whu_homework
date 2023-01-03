package ch4;

import java.util.Arrays;

public class Ch4Hw3 {
    //add
    public void addMatrix (int[][]A, int[][]B){
        if(A[0].length == B[0].length && A.length == B.length){
            int[][] addJu = new int[A.length][A[0].length];
            for(int i = 0;i<A.length;i++){
                for(int j =0;j <A[0].length;j++){
                    addJu[i][j] = A[i][j]+B[i][j];
                }
            }
            System.out.println("The Add is:");
            System.out.println(Arrays.deepToString(addJu));
        }
    }
    //multiple
    public void mulMatrix (int[][]A, int[][]B){
        if(A[0].length == B.length){
            int[][] mulJu = new int[A.length][B[0].length];
            for(int i = 0;i <A.length;i++){
                for (int j = 0;j < B[0].length;j++){
                    //length of add
                    for(int count = 0;count < A[0].length;count++){
                        mulJu[i][j] += A[i][count] + B[count][j];
                    }
                }
            }
            System.out.println("The Multiple is:");
            System.out.println(Arrays.deepToString(mulJu));
        }
    }

    public static void main(String[] args) {
        int[][] c ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] d ={{2,2,2},{1,1,1},{3,3,3}};
        Ch4Hw3 hw3 = new Ch4Hw3();
        hw3.addMatrix(c,d);
        hw3.mulMatrix(c,d);
    }
}
