// TC - O(V^3);
// SC - O(1);
// Floyd warshell algo find min distance b/w all the two nodes.
// Just take k as an Intermediate and change valaues if its smaller than the path calculated. 

class floyd
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
       
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                
            }
        }
            
            
            for(int k = 0; k < n; k++){
                
            for(int i = 0; i < n; i++){
                 
            for(int j = 0; j < n; j++){
                
          if(matrix[i][k] < Integer.MAX_VALUE && matrix[k][j] < Integer.MAX_VALUE && 
                matrix[i][j] >  matrix[i][k] + matrix[k][j])
            
                 matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]);
                
            }
        }
    }
    
        for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] >= Integer.MAX_VALUE)
					matrix[i][j] = -1;
			}
        }
    }
}