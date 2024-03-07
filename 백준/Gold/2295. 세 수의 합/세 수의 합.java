import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());

            for(int j=i; j>=0; j--){
                set.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        int ans = -1;
        for(int i=N-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                int num = arr[i] - arr[j];
                if(set.contains(num)){
                    ans = arr[i];
                    break;
                }
            }
            if(ans!=-1){
                break;
            }
        }
        System.out.println(ans);
    }
}