import java.util.*;

class Solution {
    
    static class Node{
        int r;
        int c;
        int dis;
        
        Node(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
    
    static class Rec{
        int lx;
        int ly;
        int rx;
        int ry;
        
        Rec(int lx, int ly, int rx, int ry){
            this.lx = lx;
            this.ly = ly;
            this.rx = rx;
            this.ry = ry;
        }
    }
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] ddr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] ddc = {0, 1, 0, -1, 1, -1, 1, -1};
    
    static int[][] arr;
    static List<Rec> list;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    
        arr = new int[51*2][51*2];   
        list = new ArrayList<>();
        
        for(int i=0; i<rectangle.length; i++){
            int lx = rectangle[i][0]*2;
            int ly = rectangle[i][1]*2;
            int rx = rectangle[i][2]*2;
            int ry = rectangle[i][3]*2;
            
            for(int r=ly; r<=ry; r++){
                for(int c=lx; c<=rx; c++){
                    arr[r][c] = 1;
                }
            }
            
            list.add(new Rec(lx, ly, rx, ry));
        }
        // 돌자
        Queue<Node> q = new LinkedList<>();
        boolean[][] visit = new boolean[51*2][51*2];
        
        q.offer(new Node(characterY*2, characterX*2, 0));
        visit[characterY*2][characterX*2] = true;
        
        int ans = 0;
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            if(temp.r == itemY*2 && temp.c == itemX*2){
                ans = temp.dis/2;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];
                
                if(visit[nr][nc]){
                    continue;
                }
                visit[nr][nc] = true;
                
                if(arr[nr][nc]==1){
                    boolean check = false;
                    for(int j=0; j<list.size(); j++){
                        Rec t = list.get(j);
                        
                        if(t.lx < nc && t.ly < nr && t.rx > nc && t.ry > nr){
                            check = true;
                        }
                        
                    }
                    
                    if(!check){
                        q.offer(new Node(nr, nc, temp.dis+1));
                    }

                }
            }
        }
       
        
        return ans;
    }
}