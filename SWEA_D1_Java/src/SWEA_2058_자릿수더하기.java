import java.util.Scanner;

public class SWEA_2058_자릿수더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int N_1 = N % 10;
		int N_10 = (N / 10) % 10;
		int N_100 = (N / 100) % 10;
		int N_1000 = (N / 1000) % 10;

		System.out.println(N_1 + N_10 + N_100 + N_1000);
	}
}
