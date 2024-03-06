import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr1 = new int[10001];
        int[] arr2 = new int[10001];

        arr1[1] = 1;
        arr1[2] = 1;
        arr1[3] = 2;

        arr2[2] = 1;
        arr2[3] = 1;

        for(int i=4; i<=10000; i++){
            arr1[i] = (arr1[i-1] + arr2[i-1]);
            arr2[i] = arr2[i-2];
            if(i%3 == 0){
                arr2[i]++;
            }
        }

        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());

            System.out.println(arr1[N]+arr2[N]);
        }
    }
}