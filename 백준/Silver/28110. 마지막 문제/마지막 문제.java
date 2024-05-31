import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int num = -1;
        int min = 0;

        for(int i=1; i<N; i++){
            int diff = list.get(i) - list.get(i-1);

            if(diff == 1){
                continue;
            }
            diff /= 2;
            if(min < diff){
                min = diff;
                num = list.get(i-1) + diff;
            }
        }
        System.out.println(num);
    }
}