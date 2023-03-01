import java.util.Scanner;

public class BOJ_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int len = N.length();
		int num = Integer.parseInt(N);
		for (int i = num - len * 9; i < num; i++) {
			int temp = result(i) + i;
			if (temp == num) {
				System.out.println(i);
				break;
			}
			if (i == num - 1) {
				System.out.println(0);
			}
		}
	}

	public static int result(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
