import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] list;
    public static int[] person;
    public static boolean[] visit;
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        person = new int[N+1];
        visit = new boolean[N+1];
        check = true;
        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                fill(i, 1);
            }
        }
        if(check){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
    public static void fill(int num, int flag){
        if(!check){
            return;
        }
        person[num] = flag;

        for(int i=0; i<list[num].size(); i++){
            int temp = list[num].get(i);
            if(!visit[temp]){
                visit[temp] = true;
                fill(temp, -flag);
            }else{
                if(person[temp]+flag != 0){
                    // 이분 그래프가 될 수 없다.
                    check = false;
                    return;
                }
            }
        }
    }
}