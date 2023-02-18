import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_17413 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		String[] arr = input.split(" ");
		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++) {
			List<Character> temp1 = new ArrayList<>();
			int flag = 0;
			int flag1 = 0;

			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == '<') {
					flag = 1;
				} else if (arr[i].charAt(j) == '>') {
					flag = 0;
				}

				if (flag == 1) {
					if (flag1 == 0) {
						flag = 1;
						
						for (int k = temp1.size() - 1; k >= 0; k--) {
							System.out.print(temp1.get(k));
						}
						temp1.clear();
					}
					System.out.print(arr[i].charAt(j));

				} else {
					flag1 = 0;
					if (arr[i].charAt(j) == '<' || arr[i].charAt(j) == '>') {
						System.out.print(arr[i].charAt(j));
					} else {
						temp1.add(arr[i].charAt(j));
					}
				}

			}
			for (int k = temp1.size() - 1; k >= 0; k--) {
				System.out.print(temp1.get(k));
			}
			System.out.print(" ");
		}

	}
}
