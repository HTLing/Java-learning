package homework;

public class Question2 {
	public static void main(String[] args) {
		String x = String.format("x = %.4f", (0.55*44.5 - 50.2*5.9)/(3.4*0.55 - 50.2*2.1));
		System.out.println(x);
		String y = String.format("y = %.4f", (3.4*5.9 - 2.1*44.5)/(3.4*0.55 - 50.2*2.1));
		System.out.println(y);
	}
}
