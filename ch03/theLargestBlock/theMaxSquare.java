// @Package : MaxSquare
// @Time    : 2019/10/12 23:28
// @Author  : 星空糖
// @File    : theMaxSquare.java

import java.util.Scanner;

public class theMaxSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入方阵的行数：");
        int rows = input.nextInt();
        int[][] block = new int[rows][rows];
        for(int i = 0; i < rows; i++) {
            System.out.print(String.format("请输入第%d行：",i+1));
            for (int j = 0; j < rows; j++)
                block[i][j] = input.nextInt();
        }
        int[] result = findLargestBlock(block);
        if (result[2] == 0)
            System.out.println("全零方阵，你在逗我。");
        else
            System.out.println(String.format("第一个最大块在（%d, %d）,并且大小为%d", result[0], result[1], result[2]));
    }

    private static int[] findLargestBlock(final int[][] Square) {
        int[] result = {0, 0, 0};
        int length = Square.length;
        for(int row = 0;row < length; row++)
            for(int col = 0; col < length; col++)
                if(!(Square[row][col] == 0)){
                    //当数为1的时候才进入下一步循环，否则不进入
                    //这里主要是用来判断是一个多大的全1块，往左边、下面等地方挨个看过去，遇到零则跳出
                    int size = 1;
                    //Todo: 经过一系列处理
                    try {
                        for (int i = 0; i < size + 1; i++)
                            //引发的越界异常直接吞掉，反正都要finally的
                            //正好利用这个异常跳出循环
                            if (!(Square[row + size][col + i] == 0) && !(Square[row + i][col + size] == 0))
                                size += 1;
                    } finally {
                        if(size > result[2]) {
                            result[0] = row + 1;
                            result[1] = col + 1;
                            result[2] = size;
                        }
                    }
                }
        return result;
    }
}
