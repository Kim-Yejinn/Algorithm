import java.util.Scanner;

public class BOJ_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean[] arr = new boolean[1001];

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == false) {
				int t = 2;
				while (t * i < arr.length) {
					arr[t * i] = true;
					t++;
				}
			}
		}
		arr[0] = true;
		arr[1] = true;

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[sc.nextInt()] == false) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
