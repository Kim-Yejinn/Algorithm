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

        long cnt = 0;

        for(int i=0; i<N-2; i++){
            int left = i+1;
            int right = N-1;

            while (left<right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    int cr = arr[right];
                    int cl = arr[left];
                    if(cr == cl){
                        cnt += right - left;
                        left++;
                    }else{
                        long l = 0;
                        long r = 0;


                        while (cr == arr[right--]){
                            r++;
                            if(cr != arr[right]){
                                break;
                            }
                        }
                        while (cl == arr[left++]){
                            l++;
                            if(cl != arr[left]){
                                break;
                            }
                        }

                        cnt += r * l;

                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}