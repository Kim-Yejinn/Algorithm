
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_2930_힙 {

	// 확인해야 될 테스트 케이스
	// 1. 모아서 print 따로 print
	// 2. 계속 2만 나와서 삭제해야 될 경우
	// 3. 시간초과의 경우 ArrayList, LinkedList 바꿔보기

	static int[] arr;
	static int lastIdx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			arr = new int[N + 1];
			lastIdx = 0;

			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < N; i++) {
				int c = sc.nextInt();

				if (c == 1) {
					int num = sc.nextInt();
					arr[++lastIdx] = num;

					int cur = lastIdx;
					while (cur > 1 && arr[cur] > arr[cur / 2]) {
						swap(cur, cur / 2);
						cur = cur / 2;
					}

				} else if (c == 2) {
					list.add(arr[1]);

					arr[1] = arr[lastIdx];
					arr[lastIdx--] = 0;

					if (lastIdx < 0) {
						lastIdx = 0;
					}

					int cur = 1;

					while (true) {
						int child = cur * 2;

						if (child + 1 <= lastIdx && arr[child] < arr[child + 1]) { // 오른쪽 자식이 존재하고, 오른쪽 자식이 더 크다면
							child++;
						}

						if (child > lastIdx || arr[child] < arr[cur]) {
							break;
						}

						swap(cur, child);
						cur = child;

					}

				}
			}
			System.out.print("#" + tc);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != 0) {
					System.out.print(" " + list.get(i));
				} else {
					System.out.print(" " + -1);
				}
			}

			System.out.println();
		}

	}

	private static void swap(int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
