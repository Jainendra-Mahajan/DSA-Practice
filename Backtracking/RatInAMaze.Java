//In this we use backtracking and we check all the possible directions using an visted
// array.
// Movement should be done is Legxiographical manner 
//ie. DLRU

// T.C --> O(4 ^ (m * n)) checking every directions
// S.C --> O(m * n)



class Solution {
    
    static void solve(int i , int j , int[][] arr , int n , ArrayList<String> ans , String move ,  int[][] visited){
        if(i == n - 1 && j == n - 1){
            ans.add(move);
            return;
        }
        
        // downward
        if(i + 1 < n && arr[i + 1][j] == 1 && visited[i + 1][j] == 0){
            visited[i][j] = 1;
            solve(i + 1 , j , arr , n , ans , move + 'D' ,visited);
            visited[i][j] = 0;
        }
        
        // left
        
        if(j - 1 >= 0 &&  arr[i][j - 1] == 1 && visited[i][j -1] == 0){
            visited[i][j] = 1;
            solve(i , j-1, arr , n , ans , move + 'L' , visited);
            visited[i][j] = 0;
        }
        
        //right
        if(j + 1 < n &&  arr[i][j + 1] == 1 && visited[i][j +1] == 0){
            visited[i][j] = 1;
            solve(i , j+1, arr , n , ans ,  move + 'R' , visited);
            visited[i][j] = 0;
        }
        
        // up
        if(i - 1 >= 0 &&  arr[i-1][j] == 1 && visited[i-1][j] == 0){
            visited[i][j] = 1;
            solve(i-1 , j, arr , n , ans ,  move + 'U' , visited);
            visited[i][j] = 0;
        }
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        int visited[][] = new int[n][n];
        
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = 0;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) solve(0 , 0 , m , n , ans , "", visited);
        return ans;
    }
}