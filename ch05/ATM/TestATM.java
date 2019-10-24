package ATM;

import java.util.Scanner;

// @Package : ATM
// @Time    : 2019/10/24 10:17
// @Author  : 星空糖
// @File    : TestATM.java
public class TestATM {
    public static void main(String[] args) {
        ATM myATM = new ATM();
        Scanner input = new Scanner(System.in);
        while(true) {
            int choice = myATM.MainMenu();
            switch (choice) {
                case 1 -> System.out.printf("您的余额为：%.2f。\n\n", myATM.getBalance());
                case 2 -> {
                    System.out.print("您需要取多少：");
                    myATM.AccountWithdraw(input.nextDouble());
                }
                case 3 -> {
                    System.out.print("您需要存多少：");
                    myATM.AccountDeposit(input.nextDouble());
                }
                default -> myATM.ChangeAccount();
            }
        }
    }
}
