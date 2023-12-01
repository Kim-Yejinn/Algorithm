import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			char[] arr = br.readLine().toCharArray();

			if (arr.length == 1) {
				break;
			}
			Stack<Character> tag = new Stack<>();
			boolean flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					tag.add('(');
				}
				if (arr[i] == '[') {
					tag.add('[');
				}
				if (arr[i] == ')') {
					if (tag.isEmpty()) {
						flag = true;
						break;
					} else {
						char temp = tag.pop();
						if (!(temp == '(')) {
							flag = true;
							break;
						}
					}
				}
				if (arr[i] == ']') {
					if (tag.isEmpty()) {
						flag = true;
						break;
					} else {
						char temp = tag.pop();
						if (!(temp == '[')) {
							flag = true;
							break;
						}
					}
				}
			}
			if (tag.isEmpty()) {

				if (flag) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
			} else {
				System.out.println("no");
			}

		}

	}
}