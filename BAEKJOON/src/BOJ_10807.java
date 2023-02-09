import java.util.Scanner;

public class BOJ_10807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] in = new int[N];

		for (int i = 0; i < N; i++) {
			in[i] = sc.nextInt();
		}
		int temp = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (in[i] == temp) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
