
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static class Node{
        int x;
        int r;

        Node(int x, int r){
            this.x = x;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] input=br.readLine().split(" ");
            list.add( new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.x));

        int last_x = list.get(0).x;
        int last_r = list.get(0).r;

        boolean flag = false;

        for(int i=1;i<N; i++){
            int new_x = list.get(i).x;
            int new_r = list.get(i).r;

            int d = Math.abs(last_x - new_x);
            int sum = last_r + new_r;
            int diff = Math.abs(last_r - new_r);

            if(d ==0 || sum<d || d < diff){

            }else{
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }


    }
}
