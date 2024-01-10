import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int temp = Integer.parseInt(br.readLine());

            if(left.size() == right.size()){
                // 왼쪽 넣기
                if(right.isEmpty()){
                    left.add(temp);
                }else{
                    if(right.peek()<temp){
                        left.add(right.poll());
                        right.add(temp);
                    }else{
                        left.add(temp);
                    }
                }
            }else{
                // 오른쪽 넣기
                if(left.isEmpty()){
                    right.add(temp);

                }else{
                    if(left.peek()>temp){
                        right.add(left.poll());
                        left.add(temp);
                    }else{
                        right.add(temp);
                    }
                }
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);


    }
}