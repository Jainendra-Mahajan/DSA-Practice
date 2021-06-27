//Use  BFS .. TC and SC is O(N^2)
import java.util.*;
class KnightTour
{
    static class pair{
    int x;
    int y;
    int dist;
    
    pair(int x , int y , int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
    public boolean isValid(int x , int y , int n){
        if(x > 0 && y > 0 && x <= n && y <= n) return true;
        return false;
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int kp[], int tp[], int N)
    {
        boolean[][] vis = new boolean[N + 1][N + 1];
       int dx[]={-2,-2,-1,-1,1,1,2,2};
        int dy[]={-1,1,-2,2,-2,2,-1,1};
        
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(kp[0] , kp[1] , 0));
        
        while(!q.isEmpty()){
            
            pair curr = q.remove();
           
            
            if(curr.x == tp[0] && curr.y == tp[1]){
                return curr.dist;
            }
            
            for(int i = 0; i < 8; i++){
                 int x = curr.x + dx[i];
                 int y = curr.y + dy[i];
                
                if(isValid(x , y , N) && !vis[x][y]){
                    vis[x][y] = true;
                    q.add(new pair(x , y , curr.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}