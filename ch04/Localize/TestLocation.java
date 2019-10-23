package Localize;

import java.util.Scanner;

// @Package : Localize
// @Time    : 2019/10/23 15:51
// @Author  : 星空糖
// @File    : TestLocation.java
public class TestLocation {
    public static void main(String[] args) {
        System.out.print("请输入行和列的数目：");
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        if(input.hasNext())
            input.next();   //清空后续的内容
        double[][] a = new double[row][col];
        for(int i = 0;i < row; i++) {
            System.out.printf("请输入第%d行的数据（以前%d个为准，多输入无效）：", i + 1, col);
            for(int j = 0; j < col; j++)
                a[i][j] = input.nextDouble();
            if(input.hasNext())
                input.next();   //清空后续的内容
        }
        Location position = Location.locationLargest(a);
        System.out.print(position.toSring());
    }

}
