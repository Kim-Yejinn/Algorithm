import java.util.Scanner;

public class BOJ_2564 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt(); // 가로
		int h = sc.nextInt(); // 세로

		int num = sc.nextInt(); // 상점개수
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			int ro = sc.nextInt(); // 방향
			int dis = sc.nextInt(); // 거리
			arr[i] = distance(ro, dis, w, h);
		}

		int ro = sc.nextInt();
		int dis = sc.nextInt();

		dis = distance(ro, dis, w, h);

		int sum = 0;

		for (int i = 0; i < num; i++) {
			int a = Math.abs(arr[i] - dis);
			if (a > w + h) {
				a = 2 * (w + h) - a;
			}
			sum += a;
		}
		System.out.println(sum);

	}

	static int distance(int ro, int dis, int w, int h) {
		int total = 2 * (w + h);

		switch (ro) {
		case 2:
			dis = w + h + w - dis;
			break;
		case 3:
			dis = total - dis;
			break;
		case 4:
			dis = w + dis;
			break;
		}

		return dis;
	}

}
