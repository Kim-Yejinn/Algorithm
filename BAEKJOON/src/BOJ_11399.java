import java.util.Scanner;

public class BOJ_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cnt = new int[1001];

		for (int i = 0; i < N; i++) {
			cnt[sc.nextInt()]++;
		}
		int sum = 0;
		int sum2 = 0;
		for (int i = 1; i < 1001; i++) {
			cnt[i] += cnt[i - 1];
			for (int j = 0; j < cnt[i] - cnt[i - 1]; j++) {

				sum += i;
				sum2 += sum;

			}

		} 

		System.out.println(sum2);
	}
}
