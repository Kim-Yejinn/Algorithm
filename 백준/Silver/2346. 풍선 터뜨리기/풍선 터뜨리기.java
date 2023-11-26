
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static class Node{
        int num;
        int move;

        Node(int num, int move){
            this.num = num;
            this.move = move;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();

        Deque<Node> dq = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            int input = sc.nextInt();
            dq.addLast(new Node(i, input));

        }

        while(!dq.isEmpty()){
            Node temp = dq.pollFirst();

            int t = temp.move;
            System.out.print(temp.num+" ");

            if(dq.isEmpty()){
                break;
            }
            if(temp.move<0){
                // 왼쪽
                t = Math.abs(t);
                for(int i=0; i<t; i++){
                    dq.addFirst(dq.pollLast());
                }

            }else{
                // 오른쪽
                for(int i=0; i<t-1; i++){
                    dq.addLast(dq.pollFirst());
                }
            }
        }

    }
}
