import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		str = str.toUpperCase();

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A'] += 1;
		}
		int max = -1;
		int idx = 0;
		int flag = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (arr[idx] == arr[i])
				flag++;
		}

		if (flag >= 2)
			System.out.println('?');
		else
			System.out.println((char) (idx + 'A'));
	}

}
