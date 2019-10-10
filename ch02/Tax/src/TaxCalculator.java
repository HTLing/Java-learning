// @Package : PACKAGE_NAME
// @Time    : 2019/9/22 16:23
// @Author  : 星空糖
// @File    : TaxCalculator.java
import java.util.Scanner;
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入月平均薪资：");
        double salary = input.nextDouble();
        double tax = 0;
        if(0 < salary && salary <= 5000)
            tax = 0;
        else if (5000 < salary && salary <= 8000)
            tax = (salary - 5000) * 0.03;
        else if (8000 < salary && salary <= 17000)
            tax = 90 + (salary - 8000) * 0.1;
        else if (17000 < salary && salary <= 30000)
            tax = 90 + 900 + (salary - 17000) * 0.2;
        else if (30000 < salary && salary <= 40000)
            tax = 990 + 2600 + (salary - 30000) * 0.25;
        else if (40000 < salary && salary <= 60000)
            tax = 3590 + 10000 * 0.25 + (salary - 40000) * 0.3;
        else if (60000 < salary && salary <= 85000)
            tax = 6090 + 20000 * 0.3 + (salary - 60000) * 0.35;
        else if (85000 < salary)
            tax = 12090 + 25000 * 0.35 + (salary - 85000) * 0.45;
        else {
            System.out.println("你确定你的工资没打错？");
            System.exit(1);
        }
        System.out.println(String.format("税款为%.2f。", tax));
    }
}
