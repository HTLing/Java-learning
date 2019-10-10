// @Package : homework
// @Time    : 2019/9/21 22:23
// @Author  : 星空糖
// @File    : CurrencyExchangeCalculator.java
package homework;
import java.util.Scanner;

public class CurrencyExchangeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入美元兑人民币的汇率：");
        double ratio = input.nextDouble();
        int type = -1;
        do {
            try {
                System.out.print("输入1计算人民币兑换美元，0则相反：");
                type = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("你应该输入整数！");
                String s = input.next();    //将输入管道中的字符读走，否则会出现死循环
            }
        }while(type != 0 && type != 1);

        System.out.print("请输入金额：");
        double money = input.nextDouble();

        if(type == 1) {
            System.out.println(String.format("%.2f等价于$%.2f。", money, money/ratio));
        }
        else {
            System.out.println(String.format("$%.2f等价于%.2f。", money, money * ratio));
        }
    }
}
