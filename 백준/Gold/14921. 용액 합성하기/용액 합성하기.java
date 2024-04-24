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

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        int ans = Integer.MAX_VALUE;

        while (left<right){
            int sum = arr[left] + arr[right];

            if(sum == 0){
                ans = 0;
                break;
            }else if(sum > 0){
                if(Math.abs(ans) > Math.abs(sum)){
                    ans = sum;
                }
                right--;
            }else {
                if(Math.abs(ans) > Math.abs(sum)){
                    ans = sum;
                }
                left++;
            }
        }
        System.out.println(ans);
    }
}