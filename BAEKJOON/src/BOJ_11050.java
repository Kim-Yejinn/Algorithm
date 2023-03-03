import java.util.Scanner;

public class BOJ_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(fac(N) / (fac(K) * fac(N - K)));

	}

	public static int fac(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return n * fac(n - 1);
	}
}
