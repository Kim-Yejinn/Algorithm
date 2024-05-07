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
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list= new ArrayList<>();
        for(int i=0; i<3; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}