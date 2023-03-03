import java.util.Scanner;

public class BOJ_11279 {

	static int[] arr;
	static int lastIdx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N + 1];
		lastIdx = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			if (num > 0) {
				// 삽입
				arr[++lastIdx] = num;
				int cur = lastIdx;
				while (cur > 1 && arr[cur] > arr[cur / 2]) {
					swap(cur, cur / 2);
					cur /= 2;
				}

			} else if (num == 0) {
				// 삭제
				if (lastIdx == 0) {
					System.out.println(0);
				} else {
					System.out.println(arr[1]);
					arr[1] = arr[lastIdx];
					arr[lastIdx--] = 0;

					if (lastIdx < 0) {
						lastIdx = 0;

					}

					int cur = 1;

					while (true) {
						int child = cur * 2;

						if (child + 1 <= lastIdx && arr[child] < arr[child + 1]) {
							child++;
						}

						if (child > lastIdx || arr[cur] > arr[child]) {
							break;
						}
						swap(cur, child);
						cur = child;
					}

				}
			}
		}
	}

	public static void swap(int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
