import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int remove = 0;
        if(arr[0]%2==1){
            remove++;
        }
        int len = 0;

        while(left<=right ){
            if(remove > K){
                if(arr[left] % 2 == 1){
                    remove--;
                }
                left++;
            }else{
                right++;
                if(right == N){
                    len = Math.max(len, right-left-remove);
                    break;
                }
                if(arr[right] % 2 == 1){
                    remove++;
                }
            }
            if(remove <= K){
                len = Math.max(len, right-left+1-remove);
            }
        }
        System.out.println(len);



    }
}