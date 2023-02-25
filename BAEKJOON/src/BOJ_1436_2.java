import java.util.Scanner;

public class BOJ_1436_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int f = 666;

		int cnt = 1;

		while (cnt != N) {
			f++;
			int temp = f;
			while (temp > 0) {
				if (temp % 1000 == 666) {
					cnt++;
					break;
				} else {
					temp /= 10;
				}
			}
		}
		System.out.println(f);
	}
}
