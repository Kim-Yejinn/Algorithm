import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] arr = new int[N];
        int[] ans = new int[N];
        int[] temp = new int[N];
        int[] temp2 = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = temp[i] = temp2[i] = str.charAt(i)-'0';
        }

        str = br.readLine();
        for(int i=0; i<N; i++){
            ans[i] = str.charAt(i)-'0';
        }

        int cnt = 0;
        // 시작할때 안눌렀을때
        for(int i=1; i<N; i++){
            if(temp[i-1] != ans[i-1]){
                cnt++;
                temp[i-1] ^= 1;
                temp[i] ^= 1;
                if(i!=N-1){
                    temp[i+1] ^= 1;
                }
            }
        }
        if(temp[N-1] == ans[N-1]){
            System.out.println(cnt);
        }else{
            cnt = 1;

            temp2[0] ^= 1;
            temp2[1] ^= 1;

            for(int i=1; i<N; i++){
                if(temp2[i-1] != ans[i-1]){
                    cnt++;
                    temp2[i-1] ^= 1;
                    temp2[i] ^= 1;
                    if(i != N-1){
                        temp2[i+1] ^= 1;
                    }
                }
            }
            if(temp2[N-1] == ans[N-1]){
                System.out.println(cnt);
            }else{
                System.out.println(-1);
            }
        }
    }
}