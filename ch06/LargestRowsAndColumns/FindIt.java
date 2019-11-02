package LargestRowsAndColumns;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// @Package : LargestRowsAndColumns
// @Time    : 2019/11/2 16:06
// @Author  : 星空糖
// @File    : FindIt.java
public class FindIt {
    public static void main(String[] args) {
        myMatrix matrix = new myMatrix();
        matrix.showMatrix();
        ArrayList<Integer> RowsResult = matrix.FindLargestRows();
        System.out.println("1最多的行在：" + RowsResult.toString());
        ArrayList<Integer> ColsResult = matrix.FindLargestCols();
        System.out.println("1最多的列在：" + ColsResult.toString());
    }
}

class myMatrix {
    private int size;
    private int[][] matrix;

    myMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入方阵大小：");
        try {
            int num = input.nextInt();
            if (num == 0) {
                System.out.println("0个人你是认真的嘛？默认大小为5。");
                num = 5;
            }
            size = num;
        } catch (InputMismatchException e) {
            input.next();
            System.out.println("出现异常，默认大小为5。");
            size = 5;
        } catch (NegativeArraySizeException e) {
            System.out.println("不能有负数个人，默认大小为5。");
            size = 5;
        } finally {
            matrix = new int[size][size];
            for (int i = 0; i < size; i++)
                for(int j = 0; j < size; j++)
                    matrix[i][j] = (int)(Math.random()*2);
        }
    }

    private int Sum(int[] thisArray) {
        int summary = 0;
        for(int i : thisArray)
            summary += i;
        return summary;
    }

    private void Transposition() {
        for(int i = 0; i < size; i++)
            for(int j = i + 1; j < size; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
    }

    void showMatrix() {
        System.out.println("您的方阵如下：");
        for(int i = 0 ; i < size; i++) {
            for(int j : matrix[i])
                System.out.print(j);
            System.out.print('\n');
        }
    }

    ArrayList<Integer> FindLargestRows() {
        int tempSum = -1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int sum = Sum(matrix[i]);
            if(sum > tempSum) {
                tempSum = sum;
                ans.clear();
                ans.add(i);
            } else if (sum == tempSum) {
                ans.add(i);
            }
        }
        return ans;
    }

    ArrayList<Integer> FindLargestCols() {
        Transposition();
        return FindLargestRows();
    }

}
