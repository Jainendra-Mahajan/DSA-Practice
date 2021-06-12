//Logic - Make the unsafe marked and use visited array to store places 
// that are already visited

import java.util.Arrays;

class SafePathLandmines {

    static final int R = 12;
    static final int C = 10;

    static int[] row = {-1 , 0 , 0 , 1};
    static int[] col = {0 , -1 , 1 , 0};
    static int min_dist;

    static boolean isValid(int x , int y){
        if(x < R && y < C && x >= 0 && y >= 0) return true;
        return false;
    }
    
    static void markUnsafePlace(int[][] mat){
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(mat[i][j] == 0){
                        for(int k = 0; k < 4; k++){
                            if(isValid(i + row[k] , j + col[k])){
                                mat[i + row[k]][j + col[k]] = -1;
                            }
                        }
                    }
                }
            }
            
            for(int i = 0; i < R; i++)
    {
        for(int j = 0; j < C; j++)
        {
            if (mat[i][j] == -1)
                mat[i][j] = 0;
        }
    }
    }
        static boolean isSafe(int[][] mat , boolean[][] visited , int x , int y){
            if(mat[x][y] == 0 || visited[x][y]) return false;
            return true;
        }
        
    static void HelperMethod(int[][] mat , boolean[][] visited , int i , int j , int dist){
            if(j == C -1) {
                min_dist = Math.min(dist , min_dist);
                return;
            }

            if(dist > min_dist) return;

            visited[i][j] = true;

            for(int k = 0; k < 4; k++){
                if(isValid(i + row[k], j + col[k]) && 
                isSafe(mat, visited, i + row[k], j + col[k]))
                
                {
                    HelperMethod(mat, visited, i + row[k], j + col[k], dist + 1);
                }
            }
                visited[i][j] = false;
    }

            
    static void shortestpath(int[][] mat) {
        min_dist = Integer.MAX_VALUE;

        boolean[][] visited  = new boolean[R][C];

        markUnsafePlace(mat);

        for(int i = 0; i < R; i++){
            if(mat[i][0]  == 1){

                for(int k = 0; k < R; k++){
                    Arrays.fill(visited[k] , false);  // it fills every row with false;
                }
                HelperMethod(mat , visited , i , 0 , 0);

                if (min_dist == C - 1)
                break;
            }
        }

        if (min_dist != Integer.MAX_VALUE) 
        System.out.println(min_dist);

        else {
            System.out.println("Not Found");
        }
    }
    
    public static void main(String[] args) {
        
        int[][] mat = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
            shortestpath(mat);
    }

}