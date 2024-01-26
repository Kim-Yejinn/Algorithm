import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<2*N-1; i++){
            String str = sc.next();
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
        }

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String name = it.next();
            int num = map.get(name);
            if(num %2 != 0){
                System.out.println(name);
                break;
            }
        }
    }
}