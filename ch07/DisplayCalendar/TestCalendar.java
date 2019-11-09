package DisplayCalendar;

import java.time.LocalDate;

// @Package : DisplayCalendar
// @Time    : 2019/11/8 19:08
// @Author  : 星空糖
// @File    : TestCalendar.java
public class TestCalendar {
    public static void main(String[] args) {
        //先获取今天是哪年哪月哪天
        final LocalDate Today = LocalDate.now();
        int year;
        int month = 0;
        LocalDate ThisDay;
        try {
            try{
                month = Integer.parseInt(args[0]);
                if (month < 0 || month > 12)
                    month = Today.getMonthValue();
            } catch(NumberFormatException e) {
                //说明月份输入的不是一个数字字符串
                System.out.println("月份输入不合法，默认当前月。");
                month = Today.getMonthValue();
            }
            try{
                year = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                //说明年份输入的不是一个数字字符串
                System.out.println("年份输入不合法，默认当前年。");
                year = Today.getYear();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //我寻思着这也没毛病啊……
            //这个warning不管了
            if (args.length == 0) {
                year = Today.getYear();
                month = Today.getMonthValue();
            }
            else
                year = Today.getYear();
        }
        ThisDay = LocalDate.of(year, month, 1);

        //System.out.print(ThisDay.toString());
        //周一是1，周日是0
        int value = ThisDay.getDayOfWeek().getValue() % 7;

        //这里是输出日历的地方，让我想想……
        //好吧这是抄的……
        System.out.printf("        %s, %d      \n", ThisDay.getMonth().toString(), ThisDay.getYear());
        System.out.print( " Sun Mon Tue Wed Thu Fri Sat \n");
        for(int i = 0; i < value; i++)
            System.out.print("    ");

        while(ThisDay.getMonthValue() == month) {
            //看着上面没有换行
            System.out.printf("%4d", ThisDay.getDayOfMonth());
            //加一天
            ThisDay = ThisDay.plusDays(1);
            //看看是不是到了周一
            if(ThisDay.getDayOfWeek().getValue() % 7 == 0)
                System.out.print("\n");
        }
    }
}
