import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                pq.add(sc.nextInt());
            }
        }

        for(int i=0; i<N-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
