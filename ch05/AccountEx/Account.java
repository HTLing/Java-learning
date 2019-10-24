package AccountEx;

// @Package : AccountEx
// @Time    : 2019/10/24 10:16
// @Author  : 星空糖
// @File    : Account.java
public class Account {
    /**重新构建Account类
     * 只保留那些必要的方法
     */
    private double balance;

    public Account() {
        this.balance = 100.0;
    }

    public double getBalance() {return balance;}

    public void deposit(double money) {
        this.balance += money;
    }

    public void withdraw(double money) {
        if(money > this.balance)
            System.out.print("你没有那么多钱。\n\n");
        else {
            System.out.printf("你成功取出了%.2f元钱。\n\n", money);
            this.balance -= money;
        }
    }

}
