import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1767_프로세서연결하기 {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			arr = new int[N][N];

			int core = 0;

			List<Integer> list_x = new ArrayList<>();
			List<Integer> list_y = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
					if (arr[r][c] == 1) {
						list_x.add(c);
						list_y.add(r);
					}
				}
			}

			int[] state = new int[list_x.size()];
			int finish = 0;
			while (true) {
				for (int i = 0; i < N; i++) {

				}
				finish++;
				if (finish >= Math.pow(4, N)) {
					break;
				}
			}

		}

	}
}
