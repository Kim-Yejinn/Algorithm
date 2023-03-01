import java.util.Scanner;

public class BOJ_4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a + b + c == 0) {
				break;
			}
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if (b > c) {
				int temp = b;
				b = c;
				c = temp;
			}
			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}
	}
}
