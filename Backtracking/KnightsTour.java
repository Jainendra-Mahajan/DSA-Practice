// Do simple Rescursion 
// moves of knight are stored in 2 arrays.

// TC - (8 ^ n(Sq)) as There are N^2 Cells and for each

class Knights {
    static int N = 8;
    
    static boolean solveKT(){
        int[][] chess = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                chess[i][j] = -1;
            }
        }   
            int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
            int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
            
            chess[0][0] = 0;
            
            if(!helperFunction(0 , 0 , 1 , chess , xMove , yMove)) {
            System.out.println("No Solution");
            return false;
            }
           
             else{ 
             printSolution(chess);
             return true;
             }
        }
        
        static void printSolution(int[][] sol){
            for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
        }
        
        static boolean isSafe(int x , int y , int[][] sol){
            return (x>=0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
        }
        
        static boolean helperFunction(int x , int y , int move , int[][] ans , int[] xMove , int[] yMove){
           
            
            if(move == N * N) return true;
            
            int nextX , nextY;
            
           
            for(int k = 0; k < 8; k++){
                nextX = x + xMove[k];
                nextY = y + yMove[k];
                 if (isSafe(nextX, nextY, ans)) {
               
                ans[nextX][nextY] = move;
                if(helperFunction(nextX , nextY , move + 1 , ans , xMove , yMove)) return true;
                
                else ans[nextX][nextY] = -1;
                 }
            }
            return false;
        }
    
	public static void main (String[] args) {
		solveKT();
	}
}