import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_14510_나무높이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[] arr = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (max < arr[i]) {
					max = arr[i];
				}
			}

			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				if (max - arr[i] != 0)
					list.add(max - arr[i]);

			}

			Collections.sort(list);

			int time = 0;
			while (list.size() > 0) {
				time++;

				if (time % 2 == 0) { // 짝수일때
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j) >= 2) {
							list.set(j, list.get(j) - 2);
							if (list.get(j) == 0) {
								list.remove(j);
							}
							break;
						}

					}
					Collections.sort(list);
				} else { // 홀수일때
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) > 0 && list.get(i) % 2 != 0) {
							list.set(i, list.get(i) - 1);
							if (list.get(i) == 0) {
								list.remove(i);
							}
							break;
						}
						if (i == list.size() - 1) {
							for (int j = i; j >= 0; j--) {
								if (list.get(j) != 2) {
									list.set(j, list.get(j) - 1);
									if (list.get(j) == 0) {
										list.remove(j);
									}
									Collections.sort(list);
									break;
								}

							}
						}
					}
				}
				if (list.size() == 0) {
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, time);
		}
	}
}
