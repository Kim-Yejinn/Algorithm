import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i>0){
                arr[i] += arr[i-1];
            }
        }

        int left = 0;
        int right = 0;

        int len = Integer.MAX_VALUE;

        while (right<N){
            int sum = arr[right];
            if(left-1 >=0){
                sum -= arr[left-1];
            }

            if(sum >= S){
                len = Math.min(len, right-left+1);
                left++;
            }else{
                right++;
            }
        }
        if(len == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(len);
        }
    }
}