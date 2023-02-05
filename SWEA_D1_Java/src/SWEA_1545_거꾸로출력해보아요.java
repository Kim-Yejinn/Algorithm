import java.util.Scanner;

public class SWEA_1545_거꾸로출력해보아요 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int num=sc.nextInt();
	
	for(int i=num; i>=0; i-- ) {
		System.out.print(i+" ");
	}
}
}
