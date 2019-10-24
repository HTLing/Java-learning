package ATM;
import AccountEx.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

// @Package : ATM
// @Time    : 2019/10/24 10:17
// @Author  : 星空糖
// @File    : ATM.java
class ATM {
    private Account[] Accounts;
    private Account thisAccount;

    ATM() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入账户数量：");
        try {
            int num = input.nextInt();
            Accounts = new Account[num];
            for(int i = 0; i < num; i++)
                Accounts[i] = new Account();
        } catch (InputMismatchException e) {
            System.out.println("出现异常，默认10个人。");
            Accounts = new Account[10];
        }
        ChangeAccount();
    }

    int MainMenu() {
        System.out.println("主菜单：");
        System.out.print("1. 查看余额\n2. 取款\n3. 存款\n4. 退出当前账户\n");
        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("你的选择是：");
                int num = input.nextInt();
                if(num == 1 || num == 2 || num == 3 || num == 4)
                    return num;
                else
                    System.out.println("请输入1-4之间的整数。");
            } catch (InputMismatchException e) {
                System.out.println("请输入一个整数！");
            }
        }
    }

    double getBalance() { return thisAccount.getBalance();}
    void AccountWithdraw(double money) { thisAccount.withdraw(money); }
    void AccountDeposit(double money) { thisAccount.deposit(money); }
    void ChangeAccount() {
        while(true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.printf("请输入ID编号（0-%d）：", Accounts.length - 1);
                int IDNumber = input.nextInt();
                thisAccount = Accounts[IDNumber];
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("没有这个人！");
            } catch (InputMismatchException e) {
                System.out.println("请输入一个整数！");
            }
        }
    }
}
