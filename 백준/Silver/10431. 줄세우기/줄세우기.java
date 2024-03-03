import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];
            int cnt = 0;
            for(int i=0; i<20; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            for(int i=1; i<20; i++){
                for(int j=i-1; j>=0; j--){
                    if(arr[j] > arr[i]){
                        cnt++;
                    }
                }
            }

            System.out.println(t +" "+cnt);
        }

    }
}