
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean[] check;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        list = new ArrayList<>();
        find();

        if(list.isEmpty()){
            System.out.println(0);
            return;
        }

        int lidx = 0;
        int ridx = 0;
        int sum = list.get(0);

        int cnt = 0;

        while (ridx < list.size()){
            if(sum > N){
                sum -= list.get(lidx);
                lidx++;
            }else{ // sum <= N
                if(sum == N){
                    cnt++;
                }
                ridx++;
                if(ridx == list.size()){
                    break;
                }
                sum += list.get(ridx);
            }
        }
        System.out.println(cnt);
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
