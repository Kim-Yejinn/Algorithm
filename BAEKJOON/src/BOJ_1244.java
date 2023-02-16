import java.util.Scanner;

public class BOJ_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] sw = new int[T];

		for (int i = 0; i < T; i++) {
			sw[i] = sc.nextInt();
		}

		int N = sc.nextInt();

		for (int j = 0; j < N; j++) {
			int s = sc.nextInt(); // 남 :1 여:2
			int num = sc.nextInt();

			for (int k = 0; k < T; k++) {
				if (s == 1) {
					if ((k + 1) % num == 0) {

						if (sw[k] == 1) {
							sw[k] = 0;
						} else {
							sw[k] = 1;
						}

					}
				} else if (s == 2) {

					if (num == k + 1) {

						int temp = 0;
						while (sw[k - temp] == sw[k + temp]) {
							if (sw[k - temp] == 1) {
								sw[k - temp] = 0;
								sw[k + temp] = 0;
							} else {
								sw[k - temp] = 1;
								sw[k + temp] = 1;
							}

							temp++;
							if (k - temp < 0 || k + temp > T - 1)
								break;
						}
					}

				}
			}
		}

		int cnt=0;
		for (int a = 0; a < T; a++) {
			System.out.print(sw[a] + " ");
			cnt++;
			if(cnt==20) {
				System.out.println();
				cnt=0;
			}
		}

	}
}
