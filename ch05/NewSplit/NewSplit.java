package NewSplit;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @Package : NewSplit
// @Time    : 2019/10/24 15:20
// @Author  : 星空糖
// @File    : NewSplit.java
public class NewSplit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请在下一行输入待匹配的字符串：");
        String text = input.nextLine();
        System.out.println("请在下一行输入正则表达式：");
        String regex = input.nextLine();
        String[] s = Split(text, regex);

        //修改了内部数组的生成方式，不会出现null了
        //并添加了对空串的不显示功能
        for(String str: s)
            if(!str.equals(""))
                System.out.printf("%s\n", str);
    }

    private static String[] Split(String s, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher result = regex.matcher(s);
        boolean hasFound = false;

        int EndPos = 0;
        int StartPos;
        String[] ans = new String[0];
        while(result.find()) {
            //这里的代码冗余会不会太大了？
            hasFound = true;

            StartPos = EndPos;
            EndPos = result.start();
            String str1 = s.substring(StartPos, EndPos);

            StartPos = EndPos;
            EndPos = result.end();
            String str2 = s.substring(StartPos, EndPos);

            ans = Arrays.copyOf(ans, ans.length + 2);
            ans[ans.length - 2] = str1;
            ans[ans.length - 1] = str2;
        }
        if(EndPos != s.length()){
            StartPos = EndPos;
            ans = Arrays.copyOf(ans, ans.length + 1);
            ans[ans.length - 1] = s.substring(StartPos);
        }
        if(!hasFound){
            System.out.println("没有匹配的对象。");
            return new String[]{s};
        }
        return ans;
    }
}
