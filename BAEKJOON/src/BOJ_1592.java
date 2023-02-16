import java.util.Scanner;

public class BOJ_1592 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int cnt[] = new int[N + 1];

		cnt[1] = 1;

		int person = 1;
		int count = 0;

		while (true) {
			if (cnt[person] == M)
				break;
			count++;

			if (cnt[person] % 2 == 0) {
				person -= L;
			} else {
				person += L;
			}

			if (person > N) {
				person -= N;
			}
			if (person <= 0) {
				person += N;
			}
			cnt[person] += 1;

		}

		System.out.println(count);

	}
}
