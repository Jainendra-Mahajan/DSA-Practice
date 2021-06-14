

class LongestPath {
    static int max = Integer.MIN_VALUE;
        static int m = 3;
        static int n = 10;
	    
	    static void findLongestPath(int[][] mat , int i , int j , int dest_i , int dest_j , boolean visited[][] , int sum){
	        
	        if(i < 0 || j < 0 || i >= m || j >= n || mat[i][j] == 0 || visited[i][j]) return;
	        
	        if(i == dest_i && j == dest_j){
	            if(sum > max) 
	            max = sum;
	            return;
	        }
	        
	        visited[i][j] = true;
	        
	        //down
	        findLongestPath(mat , i + 1 , j , dest_i , dest_j , visited , sum + 1);
	        
	         // left
	        findLongestPath(mat , i , j - 1 , dest_i , dest_j , visited , sum + 1);
	        
	        //Right
	        findLongestPath(mat , i , j + 1 , dest_i , dest_j , visited , sum + 1);
	       
	        // up
	        findLongestPath(mat , i - 1  , j , dest_i , dest_j , visited , sum + 1);
	        
	        
	        
	        visited[i][j] = false;
	    }
	    	public static void main (String[] args) {
	    	    
		int[][] mat =  {
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
        { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }
    };
    
  
    boolean[][] visited = new boolean[m][n];
    for(int i = 0; i < m; i++){
     for (int j = 0; j < n; j++){
      visited[i][j] = false;
    }
    }
     findLongestPath(mat, 0, 0, 1, 7 , visited , 0);
     if(max != Integer.MIN_VALUE){
     System.out.println(max);
     }
     else System.out.println("No Solution");
	}
}