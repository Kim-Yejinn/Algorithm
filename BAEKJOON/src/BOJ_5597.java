import java.util.Scanner;

public class BOJ_5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] cnt = new int[31];

		for (int i = 0; i < 28; i++) {
			cnt[sc.nextInt()] = 1;
		}
		for (int i = 1; i < 31; i++) {
			if (cnt[i] == 0)
				System.out.println(i);
		}

	}
}
