import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<Integer>[] list;
    public static int[] node;
    public static boolean[] visit;
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            node = new int[V+1];
            visit = new boolean[V+1];
            check = true;

            for(int i=0 ;i<=V; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            for(int i=1; i<=V; i++){
                if(!visit[i]){
                    dfs(i, 1);
                }
            }

            if(check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static void dfs(int num, int flag){
        if(!check){
            return;
        }

        node[num] = flag;

        for(int i=0; i<list[num].size(); i++){
            int t = list[num].get(i);

            if(visit[t]){
                if(node[t] == flag){
                    check = false;
                    return;
                }
            }else{
                visit[t] = true;
                dfs(t, -flag);
            }
        }
    }
}