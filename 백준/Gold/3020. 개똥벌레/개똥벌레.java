import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr = new int[H+1];
        arr[0] = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(i % 2 == 0){
                // 아래
                arr[1]++;
                if(num+1 <= H){
                    arr[num+1]--;
                }
            }else{
                // 위
                arr[H-num+1]++;

            }
        }
        for(int i=2; i<=H; i++){
            arr[i] += arr[i-1];
        }

        Arrays.sort(arr);

        int min = arr[0];
        int cnt = 1;

        for(int i=1; i<=H; i++){
            if(min == arr[i]){
                cnt++;
            }else{
                break;
            }
        }
        System.out.println(min+" "+cnt);

    }
}