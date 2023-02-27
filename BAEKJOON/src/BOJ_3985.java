import java.util.Scanner;

public class BOJ_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int N = sc.nextInt();

		boolean[] arr = new boolean[L + 1];

		int want_max = 0;
		int want_person = 0;
		int get_max = 0;
		int get_person = 0;
		for (int i = 1; i < N + 1; i++) {

			int P = sc.nextInt();
			int K = sc.nextInt();

			int cnt = 0;

			for (int j = P; j <= K; j++) {
				if (arr[j] == false) {
					arr[j] = true;
					cnt++;
				}
			}

			if (get_max < cnt) {

				get_max = cnt;
				get_person = i;
			}
			if (want_max < (K - P)) {
				want_max = K - P;
				want_person = i;
			}

		}
		System.out.println(want_person);
		System.out.println(get_person);

	}
}
