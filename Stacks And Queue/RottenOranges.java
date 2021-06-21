class RottenOranges
{
    
static class pair{           // To store an coordinates
    int x , y;
    
    public pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}

    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int ans = rottenOranges(grid);
        return ans;
    }
    
    static int rottenOranges(int[][] arr){
        
        Queue<pair> q = new LinkedList<>();      // Store rotten Oranges coordinate ie 2
        int ans = 0;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 2){
                    q.add(new pair(i , j));
                }
            }
            
        }
        
        q.add(new pair(-1 , -1)); // seperate the values of diff. time frames;
        
        while(!q.isEmpty()){
                
                boolean flag = false;     // to add time frame or not while going to adjacent cells
                
            while(!delim(q.peek())){
                
            pair temp = q.peek();
            
            // Right part
            if(isValid(temp.x , temp.y + 1 , arr.length , arr[0].length) && (arr[temp.x][temp.y + 1] == 1)){
                if(!flag){
                    ans++;
                    flag = true;
                }
                
                arr[temp.x][temp.y + 1] = 2;
                
                q.add(new pair(temp.x , temp.y + 1));
            }
            
            // bottom part
            if(isValid(temp.x + 1 , temp.y , arr.length , arr[0].length) && (arr[temp.x + 1][temp.y] == 1)){
                
                if(!flag){
                    ans++;
                    flag = true;
                }
                
                arr[temp.x + 1][temp.y] = 2;
                
                q.add(new pair(temp.x + 1 , temp.y));
            }
            
            // left part
            if(isValid(temp.x , temp.y - 1 , arr.length , arr[0].length) && (arr[temp.x][temp.y - 1] == 1)){
                if(!flag){
                    ans++;
                    flag = true;
                }
                
                arr[temp.x][temp.y - 1] = 2;
                
                q.add(new pair(temp.x , temp.y - 1));
            }
            //top part
            if(isValid(temp.x - 1 , temp.y , arr.length , arr[0].length) && (arr[temp.x - 1][temp.y] == 1)){
                if(!flag){
                    ans++;
                    flag = true;
                }
                
                arr[temp.x -1][temp.y] = 2;
                
                q.add(new pair(temp.x - 1 , temp.y));
            }    
            q.remove();
                
            }
        q.remove();
        
        if(!q.isEmpty()){
            q.add(new pair(-1 , -1));
        }
    }
    
    if(checkAll(arr)) return -1;
    
    return ans;
}

static boolean checkAll(int[][] arr){
      for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1)
                    return true;
            }
        }
            return false;
            
}
    
    static boolean delim(pair temp){
        return (temp.x == -1 && temp.y == -1);
    }
    
    static boolean isValid(int i , int j , int R , int C){
        return (i >= 0 && j >= 0 && i < R && j < C);
    }
}