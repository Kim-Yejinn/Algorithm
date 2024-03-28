import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long a = 0;
        long b = 0;
        long c = 0;
        long min = 3L *1_000_000_000+10;

        for(int i=0; i<N-2; i++){
            int mid = i+1;
            int right = N-1;

            while (mid < right){
                long sum = arr[i] + arr[mid] + arr[right];

                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    a = arr[i];
                    b = arr[mid];
                    c = arr[right];
                }

                if(sum == 0){
                    break;
                }else if(sum < 0){
                    mid++;
                }else{
                    right--;
                }
            }
            if(min == 0){
                break;
            }
        }

        System.out.println(a+" "+b+" "+c);
    }
}