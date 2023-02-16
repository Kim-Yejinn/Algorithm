import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 1;
		while (true) {

			if (N == 1) {
				System.out.println(1);
				break;
			}

			int temp = 1 + 3 * num * (num + 1);

			if (N <= temp) {
				System.out.println(num + 1);
				break;
			}
			num++;
		}

	}
}
