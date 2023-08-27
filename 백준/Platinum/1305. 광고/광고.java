
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String str = sc.next();

		int[] arr = getPi(str);

		System.out.println(N - arr[N - 1]);

	}

	public static int[] getPi(String str) {

		// 1. 들어갈 곳 선언하자
		int[] pi = new int[str.length()];

		// 2. 시작점 변수 선언 (같은 지점의 인덱스 표시에 사용할 것임)
		int j = 0;

		// 3. 반복하자 이땐 1부터 시작
		for (int i = 1; i < str.length(); i++) {

			// 3-1. 만약 다르다면??
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				// 이전 숫자를 찾아서 가자
				j = pi[j - 1];
			}

			// 3-2. 만약 같다면??
			if (str.charAt(i) == str.charAt(j)) {
				// 지금 위치가 앞에서 부터 어디랑 같은지 인덱스를 넣어두자
				pi[i] = ++j;
			}

		}
		return pi;
	}

}
