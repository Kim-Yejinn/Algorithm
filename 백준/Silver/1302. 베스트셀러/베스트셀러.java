import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = -1;
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i=0; i<N; i++){
            String book = br.readLine();

            if(!map.containsKey(book)){
                map.put(book, 0);
            }
            map.put(book, map.get(book)+1);
            if(max < map.get(book)){
                max = map.get(book);
            }
        }

        for(String t : map.keySet()){
            if(map.get(t) == max){
                System.out.println(t);
                break;
            }
        }
    }
}