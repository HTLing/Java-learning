package AccountEx;

// @Package : AccountEx
// @Time    : 2019/10/22 15:43
// @Author  : 星空糖
// @File    : testAccount.java
public class testAccount {
    public static void main(String[] args) {
        Account person = new Account(1122, 22000);
        person.withdraw(22001);
        person.withdraw(20000);
        person.depoist(8000);
        System.out.printf("ID：%d \n余额：%.2f \n年化利率：%.2f%% \n", person.getID(), person.getbalacne(), person.getAnnualInterestRate()*100);
        System.out.printf("月利息为 %.2f元，开户日期为 %tF %tR", person.getMonthlyInterestRate(), person.getDateCreaded(), person.getDateCreaded());
    }
}
