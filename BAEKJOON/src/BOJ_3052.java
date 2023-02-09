import java.util.Scanner;

public class BOJ_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] cnt = new int[42];

		for (int i = 0; i < 10; i++) {
			cnt[sc.nextInt() % 42] = 1;
		}
		int num = 0;
		for (int i = 0; i < 42; i++) {
			if (cnt[i] == 1)
				num++;
		}
		System.out.println(num);
	}
}
