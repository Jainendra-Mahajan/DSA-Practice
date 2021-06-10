// Logic is visit every grid[][] point and check weather 
// It is 0 or not
// If zero then what number should come there if
// in that number's row col and that particular 3 X 3 matrix
// that number should not be repeated.



class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][]){
         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    for(char c = 1; c <= 9; c++){//trial. Try 1 through 9
                        if(isValid(grid, i, j, c)){
                            grid[i][j] = c; //Put c for this cell
                            
                            if(SolveSudoku(grid))
                                return true; //If it's the solution return true
                            else
                                grid[i][j] = 0; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValid(int[][] grid, int row, int col, int c){
        for(int i = 0; i < 9; i++) {
            if(grid[i][col] != 0 && grid[i][col] == c) return false; //check row
            if(grid[row][i] != 0 && grid[row][i] == c) return false; //check column
            if(grid[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != 0 && 
grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }     

    
    //Function to print grids of the Sudoku.
    
        static void printGrid(int grid[][])
    {
        // we got the answer, just print it 
        for (int r = 0; r < 9; r++) 
        { 
            for (int d = 0; d < 9; d++) 
            { 
                System.out.print(grid[r][d]); 
                System.out.print(" "); 
            } 
           
        } 
    }
}
