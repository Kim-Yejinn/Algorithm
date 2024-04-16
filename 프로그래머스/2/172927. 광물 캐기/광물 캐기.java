import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int min;
    static int[][] choose = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    static String[] arr;
    static int size;
    static int answer;
    
    public int solution(int[] picks, String[] minerals) {
        map = new HashMap<>();
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        
        min = Integer.MAX_VALUE;
        
        arr = minerals;
        size = minerals.length;
        
        answer = Integer.MAX_VALUE;
        rec(0, picks[0], picks[1], picks[2], 0);
        return answer;
    }
    public static void rec(int sum, int dia, int iron, int stone, int idx){
        if(idx >= size){
            answer = Math.min(answer, sum);
            return;
        }
        if(dia+iron+stone == 0){
            answer = Math.min(answer, sum);
            return;
        }
        
        int cntDia = 0;
        int cntIron = 0;
        int cntStone = 0;
        
        for(int i=0; i<5; i++){
            if(idx+i >= size){
                break;
            }
            int t = map.get(arr[idx+i]);
            
            cntDia += choose[0][t];
            cntIron += choose[1][t];
            cntStone += choose[2][t];
        }
        
        if(dia > 0){
            rec(sum+cntDia, dia-1, iron, stone, idx+5);
        }   
        if(iron > 0){
            rec(sum+cntIron, dia, iron-1, stone, idx+5);
        }
        if(stone > 0){
            rec(sum+cntStone, dia, iron, stone-1, idx+5);
        }
    }
}