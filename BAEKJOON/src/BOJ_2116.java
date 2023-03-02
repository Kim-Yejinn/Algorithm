import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] sum = new int[6];

		int[] pre = new int[6];
		int[] input = new int[6];

		int[] next = new int[6];
		Map<Integer, Integer> m = new HashMap<>();

		m.put(0, 5);
		m.put(1, 3);
		m.put(2, 4);
		m.put(3, 1);
		m.put(4, 2);
		m.put(5, 0);

		// 첫번째 입력을 pre에 넣음.
		for (int i = 0; i < 6; i++) {
			input[i] = sc.nextInt();
			pre[m.get(i)] = input[i];
		}
		for (int j = 0; j < 6; j++) {
			if (input[j] == 6 || pre[j] == 6) {
				if (input[j] == 5 || pre[j] == 5) {
					sum[j] += 4;
				} else {
					sum[j] += 5;
				}
			}
			if (input[j] != 6 && pre[j] != 6) {
				sum[j] += 6;
			}
		}
		// 첫번째 입력에 따른 옆의 최대값 넣음
		// 이때는 입력과 비교

		for (int i = 1; i < N; i++) {

			for (int j = 0; j < 6; j++) {
				input[j] = sc.nextInt();
			}

			// input 받아와서 pre와 같은 것 찾아서 반대편을 next에 넣음
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					if (input[j] == pre[k]) {
						next[k] = input[m.get(j)];
					}
				}
			}

			// pre와 next비교해서 옆에서 가장큰거 넣음.
			for (int j = 0; j < 6; j++) {
				if (pre[j] == 6 || next[j] == 6) {
					if (pre[j] == 5 || next[j] == 5) {
						sum[j] += 4;
					} else {
						sum[j] += 5;
					}
				}
				if (pre[j] != 6 && next[j] != 6) {
					sum[j] += 6;
				}
			}

			// next의 값을 pre에 넣는다.
			for (int j = 0; j < 6; j++) {
				pre[j] = next[j];
			}
		}

		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (max < sum[i]) {
				max = sum[i];
			}
		}
		System.out.println(max);

	}
}
