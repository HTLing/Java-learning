// @Package : PACKAGE_NAME
// @Time    : 2019/9/22 16:57
// @Author  : 星空糖
// @File    : Palindrome.java
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String s = input.next();
        int len = s.length();
        for(int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len-1-i)) {
                System.out.println("不是回文字符串。");
                System.exit(1);
            }
        }
        System.out.println("是回文字符串。");
    }
}
