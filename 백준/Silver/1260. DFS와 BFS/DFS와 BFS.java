import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visit;

    static int N;
    static int M;
    static int V;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();


        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }
        for(int i=0; i<=N; i++){
            Collections.sort(list[i]);
        }

        // dfs
        visit = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        // bfs
        visit = new boolean[N+1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);

    }
    public static void dfs(int num){
        visit[num] = true;
        sb.append(num).append(" ");
        for(int i=0; i<list[num].size(); i++){
            int t = list[num].get(i);
            if(!visit[t]){
                dfs(t);
            }
        }
    }

    public static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visit[num] = true;

        while (!q.isEmpty()){
            int t = q.poll();
            sb.append(t).append(" ");
            for(int i=0; i<list[t].size(); i++){
                int temp = list[t].get(i);
                if(!visit[temp]){
                    q.offer(temp);
                    visit[temp] = true;
                }
            }

        }
    }

}