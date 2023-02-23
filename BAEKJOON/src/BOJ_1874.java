import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		Stack<Integer> st = new Stack<>();
		List<Character> list = new ArrayList<Character>();
		int cnt = 1;
		int end = 0;
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			boolean flag = true;
			while (flag) {
				if (!st.isEmpty() && st.peek() != temp) {
					st.push(cnt++);
					list.add('+');
				} else if (!st.isEmpty() && st.peek() == temp) {
					flag = false;
					st.pop();
					list.add('-');
				} else if (st.isEmpty()) {
					st.push(cnt++);
					list.add('+');
				}

				if (cnt > n + 1 && !st.isEmpty()) {
					flag = false;
					end = 1;
				}
			}

		}
		if (end == 1) {
			System.out.println("NO");
		} else {
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
			}
		}
	}
}
