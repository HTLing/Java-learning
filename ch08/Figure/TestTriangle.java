package Figure;
// @Package : Figure
// @Time    : 2019/11/15 22:52
// @Author  : 星空糖
// @File    : TestTriangle.java

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        //构造默认的三角形
        Triangle DefaultTriangle = new Triangle();
        System.out.println("默认的三角形：\n" + DefaultTriangle.toString());

        Scanner input = new Scanner(System.in);
        Triangle myTriangle = null;
        boolean isValid = false;
        System.out.print("\n第一构造函数测试：\n请输入三个数，#表示结束输入：");
        do {
            try {
                ArrayList<Double> sides = new ArrayList<>();
                while(!input.hasNext("#"))
                    sides.add(input.nextDouble());
                myTriangle = new Triangle(sides.toArray(new Double[] {}));
                isValid = true;
            } catch(IllegalTriangleException e) {
                System.out.print(e.getMessage() + "请重新输入：");
                input.nextLine();
            } catch(InputMismatchException e) {
                System.out.print("出现不合法字符。请重新输入：");
                input.nextLine();
            } finally {
                input.nextLine();
            }
        }while(!isValid);

        System.out.println(myTriangle.toString());
        System.out.println("周长为：" + myTriangle.getPerimeter());
        System.out.println("面积是：" + myTriangle.getArea());
        System.out.println("是否填充：" + (myTriangle.getFilled() ? "是" : "否"));
        System.out.println("颜色：" + myTriangle.getColor());

        isValid = false;
        System.out.print("\n第二构造函数测试：\n请输入三个数，#表示结束输入：");
        do {
            try {
                ArrayList<Double> sides = new ArrayList<>();
                while(!input.hasNext("#"))
                    sides.add(input.nextDouble());
                System.out.println("1. BLUE, 2. RED, 3. GREEN, 4. YELLOW, 5. BLANK, 6. WHITE");
                System.out.print("填充的颜色是（默认为透明）：");
                input.next();
                int num = input.nextInt();
                myTriangle = new Triangle(sides.toArray(new Double[] {}), true, Color.value(num));
                isValid = true;
            } catch(IllegalTriangleException e) {
                System.out.print(e.getMessage() + "请重新输入：");
                input.nextLine();
            } catch(InputMismatchException e) {
                System.out.print("出现不合法字符。请重新输入：");
                input.nextLine();
            }
        }while(!isValid);

        System.out.println(myTriangle.toString());
        System.out.println("周长为：" + myTriangle.getPerimeter());
        System.out.println("面积是：" + myTriangle.getArea());
        System.out.println("是否填充：" + (myTriangle.getFilled() ? "是" : "否"));
        System.out.println("颜色：" + myTriangle.getColor());
    }
}
