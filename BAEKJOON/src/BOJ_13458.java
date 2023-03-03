import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		int B = sc.nextInt();
		int C = sc.nextInt();
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int temp = list.get(i);
			temp -= B;
			cnt++;
			if (temp < 0) {
				temp = 0;
			}
			if (temp % C == 0) {
				cnt += temp / C;
			} else {
				cnt += temp / C + 1;
			}

		}
		System.out.println(cnt);
	}
}
