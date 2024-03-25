import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for(int i=0; i<N; i++){
            String str = br.readLine();

            int mul = 1;
            for(int j=str.length()-1; j>=0; j--){
                int t = str.charAt(j) - 'A';
                arr[t] += mul;
                mul *= 10;
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int sum = 0;
        for(int i=0; i<9; i++){
            sum += num * arr[25-i];
            num--;
        }
        System.out.println(sum);

    }
}