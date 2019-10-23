package AccountEx;

import java.util.Date;

// @Package : AccountEx
// @Time    : 2019/10/22 15:43
// @Author  : 星空糖
// @File    : Account.java
class Account {
    private int ID;
    private double balance;
    private double annualInterestRate;
    final private Date createdDate;

    public Account() {
        ID = 0;
        balance = 0.0;
        annualInterestRate = 0.045;
        createdDate = new Date();
    }
    public Account(int newID, double newBalance) {
        ID = newID;
        balance = newBalance;
        annualInterestRate = 0.045;
        createdDate = new Date();
    }
    public int getID() { return ID; }
    public void changeID(int newID) { ID = newID; }
    public double getbalacne() { return balance; }
    public void withdraw(double money) {
        if(money > balance)
            System.out.println("你没有那么多钱！");
        else {
            System.out.println(String.format("你已经成功取出%.2f元，账户余额%.2f元", money, balance - money));
            balance -= money;
        }
    }
    public void depoist(double money) { balance += money; }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public double getMonthlyInterestRate() { return balance * (annualInterestRate / 12); }
    public Date getDateCreaded() { return createdDate; }
}
