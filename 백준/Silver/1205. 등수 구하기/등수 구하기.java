import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(S);
        Collections.sort(list, Collections.reverseOrder());

        int idx = 1;
        if(list.size() > P && list.get(P) >= S){
            System.out.println(-1);
        }else{
            int last = list.get(0);
            for(int i=0; i<list.size(); i++){
                int t = list.get(i);

                if(last != t){
                    idx = i+1;
                    last = t;
                }
                if(t == S){
                    System.out.println(idx);
                    break;
                }
            }
        }
    }
}