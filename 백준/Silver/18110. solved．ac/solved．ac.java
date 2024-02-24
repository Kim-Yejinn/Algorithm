import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int cut = (int) Math.round(N * 0.15);

        long sum = 0;

        for(int i=cut; i<N-cut; i++){
            sum += list.get(i);
        }

        System.out.println(Math.round(sum*1.0 / (N- 2*cut)));


    }
}