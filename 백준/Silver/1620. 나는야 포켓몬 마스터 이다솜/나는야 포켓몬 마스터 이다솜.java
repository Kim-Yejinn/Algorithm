import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> strToInt = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            strToInt.put(str, i);
            list.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String str = br.readLine();

            if(strToInt.containsKey(str)){
                sb.append(strToInt.get(str)).append("\n");
            }else{
                int num = Integer.parseInt(str) - 1;
                sb.append(list.get(num)).append("\n");
            }
        }
        System.out.println(sb);
    }
}