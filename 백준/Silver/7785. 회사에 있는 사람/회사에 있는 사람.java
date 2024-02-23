import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Boolean> map = new TreeMap<>(Comparator.reverseOrder());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String oper = st.nextToken();

            if(oper.equals("enter")){
                map.put(name, true);
            }else{
                map.put(name, false);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String i : map.keySet()){
            if(map.get(i)){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}