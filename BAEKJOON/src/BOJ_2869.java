import java.util.Scanner;

public class BOJ_2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		int h = V - A;
		int day = A - B;

		if (h % day == 0) {
			System.out.println(h / day + 1);
		} else {
			System.out.println(h / day + 2);
		}

	}
}
