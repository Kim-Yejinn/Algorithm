import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int K = sc.nextInt();

		List<Integer> list = new LinkedList<>();

		List<Integer> ans = new LinkedList<>();
		for (int j = 1; j <= N; j++) {
			list.add(j);
		}

		int cnt = 0;
		int idx = 0;

		while (list.size() > 0) {
			if (cnt == K) {
				cnt = 0;
			}

			if (idx == list.size()) {
				idx = 0;
			}

			if (cnt == K - 1) {
				ans.add(list.get(idx));
				list.remove(idx);
				idx--;

			}
			cnt++;
			idx++;
		}
		System.out.print("<");
		for (int i = 0; i < ans.size() - 1; i++) {
			System.out.print(ans.get(i) + ", ");
		}
		System.out.print(ans.get(ans.size() - 1) + ">");
	}
}