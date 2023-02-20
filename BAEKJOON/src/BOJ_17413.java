import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_17413 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		char[] arr = input.toCharArray();

		int flag = 0;
		List<Character> temp = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '<') {
				flag = 1;
				reverse(temp);
				temp.clear();
				continue;
			}
			if (arr[i] == '>') {
				flag = 0;
				System.out.print("<");
				forward(temp);
				System.out.print(">");
				temp.clear();
				continue;
			}
			if (arr[i] == ' ' && flag == 0) {
				reverse(temp);
				temp.clear();
				System.out.print(" ");
				continue;
			}
			if (i == arr.length - 1 && temp.size() != 0) {
				temp.add(arr[i]);
				reverse(temp);
			}
			temp.add(arr[i]);
		}

	}

	static void reverse(List<Character> arr) {

		for (int k = arr.size() - 1; k >= 0; k--) {
			System.out.print(arr.get(k));
		}
	}

	static void forward(List<Character> arr) {
		for (int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k));
		}
	}

}
