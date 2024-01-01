import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Node{
        int dis;
        int time;

        Node(int dis, int time){
            this.dis = dis;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int max = 100000;

        int[] visit = new int[max+1];

        Arrays.fill(visit, Integer.MAX_VALUE);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visit[N] = 0;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.time>=min){
                continue;
            }
            if(temp.dis == K){
                min = temp.time;
                continue;
            }

            int n1 = temp.dis+1;
            int n2 = temp.dis-1;
            int n3 = temp.dis*2;

            if(!(n1<0||n1>max)){
                if(visit[n1]>temp.time+1){
                    q.offer(new Node(n1, temp.time+1));
                    visit[n1] = temp.time+1;
                }
            }

            if(!(n2<0||n2>max)){
                if(visit[n2]>temp.time+1){
                    q.offer(new Node(n2, temp.time+1));
                    visit[n2] = temp.time+1;
                }
            }

            if(!(n3<0||n3>max)){
                if(visit[n3]>temp.time){
                    q.offer(new Node(n3, temp.time));
                    visit[n3] = temp.time;
                }
            }

        }
        System.out.println(min);
    }
}