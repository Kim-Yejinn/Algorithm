
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visit;
	static List<Integer> ans;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		ans = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				flag = false;
				rec(i, arr[i]);
			}

		}
		Collections.sort(ans);

		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

	public static void rec(int x, int num) {
		if (x == num) {
			flag = true;
			ans.add(num);
			return;
		}

		if (!visit[num]) {
			visit[num] = true;
			rec(x, arr[num]);

			if (!flag) {
				visit[num] = false;
			} else {
				ans.add(num);
			}
		}
	}
}
