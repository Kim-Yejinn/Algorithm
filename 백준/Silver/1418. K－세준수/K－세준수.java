import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int K;
    static boolean[] check;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        list = new ArrayList<>();
        find();
        int cnt = 0;

        for(int i=2; i<=N; i++){
            int max = -1;
            for(Integer x : list){
                if(x>N){
                    break;
                }
                if(i%x == 0){
                    max = x;
                }
                if(max > K){
                    break;
                }
            }
            if(max <= K && max != -1){
                cnt++;
            }
        }
        // 1씩 왜 차이나지..?
        System.out.println(cnt+1);

    }
    public static void find(){
        for(int i=2; i<=N; i++){
            if(!check[i]){
                int idx = i;
                list.add(i);
                while(idx <= N){
                    check[idx] = true;
                    idx += i;
                }
            }
        }
    }
}
