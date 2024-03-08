import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int cnt = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        for(int i=0; i<N; i++){

            int left = 0;
            int right = N-1;

            while (left < right){
                int num = arr[left] + arr[right];

                if(arr[i] == num){
                    if(left == i){
                        left++;
                    }else if(right == i){
                        right--;
                    }else{
                        cnt++;
                        break;
                    }
                }else if(arr[i] < num){
                    right--;
                }else if(arr[i] > num){
                    left++;
                }
            }

        }
        System.out.println(cnt);
    }
}