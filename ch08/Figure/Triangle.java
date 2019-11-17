package Figure;
// @Package : Figure
// @Time    : 2019/11/14 23:06
// @Author  : 星空糖
// @File    : Triangle.java

import java.util.Arrays;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    Triangle() {
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    Triangle(Double[] sides) throws IllegalTriangleException {
    	super();
    	if (sides.length < 3)
    	    throw new IllegalTriangleException("边长数量不足！");
    	else if(sides.length > 3) {
    	    throw new IllegalTriangleException("参数过多。");
        }
    	Arrays.sort(sides);
    	if(checkNotValid(sides))
    	    throw new IllegalTriangleException("输入边长不合法。");
    	this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
    }

    Triangle(Double[] sides, boolean filled, Color name) throws IllegalTriangleException {
        super(filled, name);
        if (sides.length < 3)
            throw new IllegalTriangleException("边长数量不足！");
        else if(sides.length > 3) {
            throw new IllegalTriangleException("参数过多。");
        }
        Arrays.sort(sides);
        if(checkNotValid(sides))
            throw new IllegalTriangleException("输入边长不合法。");
        this.side1 = sides[0];
        this.side2 = sides[1];
        this.side3 = sides[2];
    }

    private boolean checkNotValid(Double[] sides) { return sides[0] + sides[1] <= sides[2]; }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }
    boolean getFilled() { return super.Filled(); }
    Color getColor() { return super.getColorName(); }

    double getPerimeter() { return side1 + side2 + side3; }
    double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return String.format("三角形 第一边：%.2f, 第二边：%.2f, 第三边：%.2f。", side1, side2, side3);
    }
}

/**
 * 表示三角形不合法的异常
 * <p>
 *     编号1： 输入参数过少
 *     编号2： 输入参数过多
 *     编号3： 边长不符合三角形构成的条件
 * </p>
 */
class IllegalTriangleException extends Exception {
    IllegalTriangleException(String s) {
        super(s);
    }
}