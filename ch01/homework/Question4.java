package homework;

import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入分钟数：");
		int minutes = input.nextInt();
		int hours = minutes/60;
		int days = hours/24;
		int years = days/365;
		int days_remaining = days%365;
		String s = String.format("这些分钟数代表了%d年以及%d天", years, days_remaining);
		System.out.println(s);
	}
}