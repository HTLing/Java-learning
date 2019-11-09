package UseBigDecimal;

import java.util.InputMismatchException;
import java.util.Scanner;

// @Package : UseBigDecimal
// @Time    : 2019/11/9 16:21
// @Author  : 星空糖
// @File    : UseIt.java
public class UseIt {
    public static void main(String[] args) {
        Rational a = null;
        Rational b = null;
        Scanner input = new Scanner(System.in);

        try {
            int num1 = 0, num2 = 0;
            try {
                System.out.print("请输入第一个分式（分子、分母）：");
                num1 = input.nextInt();
                num2 = input.nextInt();
                a = new Rational(num1, num2);
            } catch(DenominatorIsZeroException e) {
                System.out.print("第一个数" + e.getMessage() +"\n请重新分母输入：");
                a = new Rational(num1, input.nextInt());
            }

            try {
                System.out.print("请输入第二个分式（分子、分母）：");
                num1 = input.nextInt();
                num2 = input.nextInt();
                b = new Rational(num1, num2);
            } catch(DenominatorIsZeroException e) {
                System.out.print("第二个数" + e.getMessage() + "\n请重新分母输入：");
                b = new Rational(num1, input.nextInt());
            }
        } catch(InputMismatchException e) {
            System.out.print("输入有非法字符，程序结束。");
            System.exit(-1);
        }

        System.out.println(a.toString() + " + " + b.toString() + " = " + a.add(b).toString());
        System.out.println(a.toString() + " - " + b.toString() + " = " + a.minus(b).toString());
        System.out.println(a.toString() + " * " + b.toString() + " = " + a.multiply(b).toString());
        System.out.println(a.toString() + " / " + b.toString() + " = " + a.divide(b).toString());
    }
}
