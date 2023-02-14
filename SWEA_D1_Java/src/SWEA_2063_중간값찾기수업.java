import java.util.Scanner;

public class SWEA_2063_중간값찾기수업 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cnt = new int[200];
		for (int i = 0; i < N; i++) {
			cnt[sc.nextInt()]++;
		}

		int sum = 0;
		for (int j = 0; j < N; j++) {
			sum += cnt[j];
			if (sum > N / 2) {
				System.out.println(j);
				break;
			}
		}
	}
}
