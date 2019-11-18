package MyBinary;
// @Package : MyBinary
// @Time    : 2019/11/17 22:01
// @Author  : 星空糖
// @File    : Binary.java

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入一个二进制字符串：");
            String bin = input.nextLine();
            bin2dec(bin);
        } catch(NumberFormatException e) {
            System.out.println("二进制字符串不合法：" + e.getMessage());
            System.exit(1);
        }
    }

    private static void bin2dec(String binaryString) throws NumberFormatException {
        char[] binary = binaryString.toCharArray();

        int sum;
        if(binary[0] - 48 != 0 && binary[0] - 49 != 0)
            throw new NumberFormatException(0);
        else
            sum = binary[0] - 48;

        for(int i = 1; i < binary.length; i++) {
            if ((binary[i] != '1') && (binary[i] != '0'))
                throw new NumberFormatException(i);
            sum = 2 * sum + binary[i] - 48;
        }
        System.out.print("转化为十进制为：" + sum);
    }
}

class NumberFormatException extends Exception {
    NumberFormatException(int n) {
        super("第" + (n + 1) + "个元素不是0或者1！");
    }
}