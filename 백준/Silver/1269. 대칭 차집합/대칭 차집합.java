import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        Set<Integer> aList = new HashSet<>();
        Set<Integer> bList = new HashSet<>();

        for(int i=0; i<A; i++){
            aList.add(sc.nextInt());
        }
        for(int j=0; j<B; j++){
            bList.add(sc.nextInt());
        }

        Iterator<Integer> aIt = aList.iterator();
        Iterator<Integer> bIt = bList.iterator();

        int cnt = 0;

        while (aIt.hasNext()){
            int temp = aIt.next();
            if(!bList.contains(temp)){
                cnt++;
            }
        }

        while (bIt.hasNext()){
            int temp = bIt.next();
            if(!aList.contains(temp)){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}