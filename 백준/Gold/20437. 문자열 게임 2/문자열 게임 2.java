import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int tc=0; tc<T; tc++){
            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] list = new ArrayList[26];

            for(int i=0; i<26; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<str.length(); i++){
                int t = str.charAt(i)-'a';
                list[t].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = 0;

            for(int i=0; i<26; i++){
                if(list[i].size() < N){
                    continue;
                }
                int diff = N-1;
                for(int j=diff; j<list[i].size(); j++){

                    min = Math.min(min, list[i].get(j) - list[i].get(j-diff)+1);
                    max = Math.max(max, list[i].get(j) - list[i].get(j-diff)+1);
                }
            }

            if(max == 0 || min == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min +" " + max);
            }

        }

    }
}