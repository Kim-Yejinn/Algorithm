import java.util.Scanner;

public class SWEA_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int N = sc.nextInt();

			int[] arr = new int[N + 4];
			int cnt = 0;
			for (int j = 2; j < arr.length; j++) {
				if (j <= N + 1) {
					arr[j] = sc.nextInt();
				}
				if (j >= 4) {
					int temp_min = 255;
					int temp_diff = 0;
					for (int k = 0; k < 5; k++) {
						if (k != 2) {
							int temp = arr[j - 2];
							temp -= arr[j - k]; // 비교할 인덱스의 값

							if (temp < 0) { // 음수일경우 그냥 도는거 x
								temp_min = 0;
								break;
							} else { // 양수일경우, 나보다 낮은거 임시 차이 구해놓음.
								temp_diff = temp;
							}
							// 계속 돌면서 최소 값을 찾음
							if (temp_min > temp_diff) {
								temp_min = temp_diff;
							}
						}
					}
					cnt += temp_min;
				}
			}
			System.out.printf("#%d %d\n", i, cnt);
		}
	}
}
