class floodFillSol {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            
        int m = image.length;
        int n = image[0].length;
        
        boolean vis[][] = new boolean[m][n];
            dfs(image , sr , sc , newColor , image[sr][sc]  , vis);
            return image;
        
    }
    
    void dfs(int[][] arr , int i , int j , int color , int res , boolean[][] vis){
        
        int rl = arr.length;
        int cl = arr[0].length;
        
        if(i < 0 || j < 0 || i >=rl || j>=cl ||arr[i][j] != res || vis[i][j])
            return;
        
        arr[i][j] = color;
        
        vis[i][j] = true;
        
        dfs(arr , i , j - 1 , color , res , vis);
        dfs(arr , i + 1 , j  , color , res , vis);
        dfs(arr , i , j + 1 , color , res , vis);
        dfs(arr , i - 1 , j , color , res , vis);
        
    }
    
}