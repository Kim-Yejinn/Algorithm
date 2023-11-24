import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		s: for (int i = 0; i < T; i++) {
			Stack<Character> st = new Stack<>();
			String str = sc.next();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					st.push(str.charAt(j));
				} else if (str.charAt(j) == ')') {
					if (st.isEmpty()) {
						System.out.println("NO");
						continue s;
					} else {
						st.pop();
					}
				}
			}
			if (st.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
