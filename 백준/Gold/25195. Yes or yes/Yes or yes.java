import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static boolean[] isExist;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        flag = true;
        isExist = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // 단방향
        }

        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            int t = Integer.parseInt(st.nextToken());
            isExist[t] = true;
        }
        check(1, false);

        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("yes");
        }
    }
    public static void check(int num, boolean gom){
        if(list[num].isEmpty()){
            // 끝까지 돌았을 때
            if(!gom && !isExist[num]){
                flag = false;
            }
        }
        if(!flag){
            return;
        }
        for(int i=0; i<list[num].size(); i++){
            int next = list[num].get(i);
            if(isExist[num]){
                check(next, true);
            }else{
                check(next, gom);
            }
        }
    }
}