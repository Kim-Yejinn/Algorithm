import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer>[] list = new ArrayList[N+1];
        int[] answer = new int[N+1];
        boolean[] visit = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()){
            int num = q.poll();
            for(int i=0; i<list[num].size(); i++){
                int t = list[num].get(i);
                if(!visit[t]){
                    answer[t] = num;
                    visit[t] = true;
                    q.offer(t);
                }
            }
        }

        for(int i=2; i<=N; i++){
            System.out.println(answer[i]);
        }
    }
}