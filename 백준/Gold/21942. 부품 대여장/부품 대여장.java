import java.util.*;

public class Main {
    public static class Person{
        long money;
        String name;

        Person(long money, String name){
            this.money = money;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] time = {60, 1440};

        String str = sc.next();
        int DDD = Integer.parseInt(str.substring(0, 3));
        int hh = Integer.parseInt(str.substring(4, 6));
        int mm = Integer.parseInt(str.substring(7));

        int rental = DDD*time[1] + hh*time[0] + mm;

        int F = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) ->{
            return o1.name.compareTo(o2.name);
        } );

        for(int i=0; i<N; i++){
            String temp = sc.next();

            int MM = Integer.parseInt(temp.substring(5, 7));
            int DD = Integer.parseInt(temp.substring(8, 10));

            temp = sc.next();

            int H = Integer.parseInt(temp.substring(0, 2));
            int M = Integer.parseInt(temp.substring(3, 5));

            int cal = DD * time[1] + H*time[0] + M;

            for(int j=1; j<=MM-1; j++){
                cal += day[j] * time[1];
            }

            String obj = sc.next();
            String name = sc.next();
            String sum = obj+name;
            if(map.containsKey(sum)){
                int diff = cal - map.get(sum);
                if(diff > rental){
                    pq.offer(new Person((diff-rental)*F, name));
                }
                map.remove(sum);

            }else{
                map.put(sum, cal);
            }
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            ArrayList<Person> list = new ArrayList<>();

            while (!pq.isEmpty()){
                Person temp = pq.poll();
                if(!list.isEmpty() && list.get(list.size()-1).name.equals(temp.name)){
                    Person t = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(new Person(t.money+temp.money, temp.name));
                }else{
                    list.add(temp);
                }
            }

            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i).name).append(" ").append(list.get(i).money).append("\n");
            }

            System.out.println(sb);
        }
    }
}