package Localize;

// @Package : Localize
// @Time    : 2019/10/23 15:51
// @Author  : 星空糖
// @File    : Location.java
public class Location {
    private int row;
    private int column;
    private double MaxValue;

    public Location(int r, int c, double num) {
        this.row = r;
        this.column = c;
        this.MaxValue = num;
    }

    public String toSring() {
        String s = String.format("最大的数在(%d,%d)处，值为%.4f。\n", this.row + 1, this.column + 1, this.MaxValue);
        return s;
    }

    public static Location locationLargest(final double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rrow = 0;
        int ccol = 0;
        double tempMax = 0 - Double.MAX_VALUE;  //表示最小的可能数，减少之后的判断次数
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(matrix[i][j] > tempMax) {
                    rrow = i;
                    ccol = j;
                    tempMax = matrix[i][j];
                }
        return new Location(rrow, ccol, tempMax);
    }
}
