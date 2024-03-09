import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ansL = arr[0];
        int ansR = arr[N-1];
        int ansC = Math.abs(arr[0]+arr[N-1]);

        int left = 0;
        int right = N-1;

        while (left < right){
            int cal = arr[left] + arr[right];

            if(Math.abs(cal) < ansC){
                ansL = arr[left];
                ansR = arr[right];
                ansC = Math.abs(cal);
            }
            if(cal == 0){
                break;
            }

            if(cal > 0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(ansL +" " + ansR);
    }
}