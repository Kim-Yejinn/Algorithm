
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 계단수

		int[] arr = new int[n + 1];
		int[] memo = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		memo[1] = arr[1];
		if (n >= 2) {
			memo[2] = arr[2] + arr[1];
		}
		// 1. 지금 위치가 선택되었을 경우 -> 직전이 선택 안됨 => i-2의 최대값에 현재 추가
		// 2. 지금 위치가 선택되었을 경우 -> 직전도 선택 됨 => i-3의 최대값에 i-1, i값 추가

		for (int i = 3; i <= n; i++) {
			int a = memo[i - 2] + arr[i];
			int b = memo[i - 3] + arr[i] + arr[i - 1];

			memo[i] = Math.max(a, b);
		}
		System.out.println(memo[n]);

	}
}
