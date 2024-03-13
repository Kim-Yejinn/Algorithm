import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static List<Integer>[] list;
    static int[] select;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        list = new List[N+1];
        select = new int[N+1];
        ans = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());

            for(int j=0; j<M; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        rec(1);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
    public static void rec(int num){
        if(num == N+1){
            int ret = check();
            if(ret == 2){
                ans = Math.min(ans, cal());
            }
            return;
        }

        rec(num+1);
        select[num] = 1;
        rec(num+1);
        select[num] = 0;
    }
    public static int cal(){
        int zero = 0;
        int one = 0;
        for(int i=1; i<=N; i++){
            if(select[i] == 1){
                one += people[i];
            }else{
                zero += people[i];
            }
        }
        return Math.abs(zero-one);
    }
    public static int check(){
        boolean[] visit = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                q.offer(i);
                visit[i] = true;
                cnt++;
            }
            while (!q.isEmpty()){
                int t = q.poll();
                for(int j=0; j<list[t].size(); j++){
                    int num = list[t].get(j);
                    if(select[i] != select[num]){
                        continue;
                    }
                    if(!visit[num]){
                        q.offer(num);
                        visit[num] = true;
                    }
                }
            }
        }
        return cnt;
    }
}