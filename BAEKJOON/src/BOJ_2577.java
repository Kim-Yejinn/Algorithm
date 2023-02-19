import java.util.Scanner;

public class BOJ_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		long mul = A * B * C;

		int[] cnt = new int[10];
		if (mul == 0) {
			cnt[0] += 1;
		}
		while (mul > 0) {
			cnt[(int) mul % 10] += 1;
			mul /= 10;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}
}
