
public class SWEA_2027_대각선출력하기 {

	public static void main(String[] args) {
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				if (i == j)
					System.out.print('#');
				else
					System.out.print('+');
			}
			System.out.println();
		}
	}
}
