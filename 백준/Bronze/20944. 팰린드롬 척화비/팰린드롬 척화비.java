import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[] arr = new char[N];
        Arrays.fill(arr, 'a');
        System.out.println(arr);
    }
}