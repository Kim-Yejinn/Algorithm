import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int M = sc.nextInt();

            StringBuilder sb = new StringBuilder();
            PriorityQueue<Integer> first = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> last = new PriorityQueue<>();

            int cnt = 0;

            for(int i=1; i<=M; i++){
                int input = sc.nextInt();


                if(first.size() == last.size()){
                    if(last.isEmpty()){
                        first.add(input);
                    }else{
                        if(last.peek()<input){
                            first.add(last.poll());
                            last.add(input);
                        }else{
                            first.add(input);
                        }
                    }
                }else{
                    if(first.isEmpty()){
                        last.add(input);
                    }else{
                        if(first.peek()>input){
                            last.add(first.poll());
                            first.add(input);
                        }else{
                            last.add(input);
                         }
                    }
                }

                if(i%2==1){
                    sb.append(first.peek()).append(" ");
                    cnt++;
                    if(cnt%10 == 0){
                        sb.append("\n");
                    }
                }
            }
            System.out.println(cnt);
            System.out.println(sb);
        }
    }
}