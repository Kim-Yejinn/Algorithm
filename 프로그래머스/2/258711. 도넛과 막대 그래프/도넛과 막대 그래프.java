import java.util.*;

class Solution {
    
    static List<Integer>[] list;
    static int[] inDegree;
    static int[] outDegree;
    
    static int SIZE;
    
    public int[] solution(int[][] edges) {
        SIZE = 0;
        for(int i=0; i<edges.length; i++){
            SIZE = Math.max(SIZE, Math.max(edges[i][0], edges[i][1]));
        }
        
        list = new ArrayList[SIZE+1];
        inDegree = new int[SIZE+1];
        outDegree = new int[SIZE+1];
        
        for(int i=0; i <= SIZE; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            list[a].add(b);
            inDegree[b]++;
            outDegree[a]++;
        }
        
        int start = 0;
        for(int i=0; i<SIZE; i++){
            if(inDegree[i] == 0 && outDegree[i] >= 2){
                start = i;
                break;
            }
        }
        int[] ans = new int[4];
        ans[0] = start;
        
        for(int i=0; i<list[start].size(); i++){
            int num = list[start].get(i);
            boolean flag = false;
            boolean flag2 = false;
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(num);
            
            while(!q.isEmpty()){
                int cur = q.poll();
                
                if(list[cur].size() >= 2){
                    ans[3]++;
                    flag = true;
                    break;
                }
                if(cur == num && flag2){
                    ans[1]++;   
                    flag = true;
                    break;
                }                
                flag2 = true;
                for(int j=0; j<list[cur].size(); j++){ 
                    q.offer(list[cur].get(j)); 
                }          
            }
            
            if(!flag){
                ans[2]++;
            }
        }

        return ans;
    }
}