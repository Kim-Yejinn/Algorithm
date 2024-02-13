import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int H;

    static int[] depth; // 비교해서 같은 높이로 만들고 등등 하려구
    static int[][] par; // i 번째 전 노드를 표현하기 위함.
    static List<Integer>[] list; // 연결된 노드들 표현하기 위함

    static boolean[] check; // root 노드를 찾기 위해서

    public static int getHeight(int num){
        return (int) Math.ceil(Math.log(num)/Math.log(2)) +1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());

            // 1. 트리의 높이를 구한다 -> 배열의 크기를 정해주기 위함
            H = getHeight(N);

            depth = new int[N+1];
            par = new int[N+1][H]; // i의 2^j 번째 조상을 나타냄
            check = new boolean[N+1];

            list = new ArrayList[N+1];

            for(int i=0; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
                check[b] = true;
            }

            // root 노드라는 것은 부모 노드가 존재하지 않는다는 소리임.
            int root = 0;
            for(int i=1; i<=N; i++){
                if(!check[i]){
                    root = i;
                    break;
                }
            }

            init(root, 1, 0);
            fillParent();

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }

    }


    public static void init(int cur, int h, int parent){
        // dfs로 모든 값을 돌면서 depth와 1번째 부모를 지정해주는 작업

        // 1. depth 지정
        depth[cur] = h;

        // 2. 연결된 노드들을 돌면서 값을 바꿔줄 것임
        for(int i=0; i<list[cur].size(); i++){
            int t = list[cur].get(i);

            // 양방향으로 되어 있기 때문에 부모가 아닐 경우만 실행
            if(t != parent){
                init(t, h+1, cur);
                // 3. 1(2^0)번째 전 부모를 넣어준다
                par[t][0] = cur;
            }
        }
    }

    public static void fillParent(){
        // 모든 부모를 정해주는 작업
        // 현재 부모의 부모의 부모의 .... 를 찾는 점화식은
        // par[a][b] = par[이전 부모][b-1] => par[par[a][b-1]][b-1]
        // par[a][b] 의 의미는 a의 2^b 번째 전 부모를 뜻한다.

        // depth 별로 모든 노드의 이전 부모를 구한다!
        for(int i=1; i<H; i++){
            for(int j=1; j<=N; j++){
                par[j][i] = par[par[j][i-1]][i-1];
            }
        }
    }

    public static int LCA(int a, int b){
        // a와 b의 공통조상을 찾는다
        // 가정) a의 깊이가 더 깊은 상태
        if(depth[a] < depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        // 1. a와 b의 depth가 같아질 때 까지 올라간다
        // 1부터 시작하는 것이 아닌 2^H부터 하는 것이 시간복잡도가 더 낮다
        for(int i=H-1; i>=0; i--){
            if(Math.pow(2, i) <= depth[a]-depth[b]){
                // depth 차이가 2^i 보다 작을때를 찾자
                // 가장 크게 이동할 수 있는 i를 구하는 작업
                a = par[a][i];
            }
        }

        if(a == b){
            // 같은 값을 가르킬 경우 지금이 공통조상
            // 이 경우는 b가 a의 조상중에 있었던 경우임
            return a;
        }

        // 2. 함께 올라가면서 같아지는 지점을 찾는 것
        for(int i = H-1; i>=0; i--){
            if(par[a][i] != par[b][i]){
                // 다를 경우 올라간다.
                a = par[a][i];
                b = par[b][i];
            }
        }

        return par[a][0];
    }
}