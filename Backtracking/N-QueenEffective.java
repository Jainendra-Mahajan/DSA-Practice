// We have optimized the approach to check weather the position to put queen 
// is available or not

// for left side - created array of size(n)
// for upper diagonal used formula is (n - 1 + row -  col) of size (2n -1 )
//for lower diagonal formula is (row + col)

// if queen is already at any of these sum of position we can change row.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
            List<List<String>> res = new ArrayList<List<String>>();
        
        int[] leftrow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] downDiagonal = new int[2 * n - 1];
        
        solve(0 , board , res , leftrow , upperDiagonal , downDiagonal);
        return res;
    }
    
   private void solve(int col , char[][] board ,  List<List<String>> res , int[] leftrow , 
                      int[] upperDiagonal , int[] downDiagonal){
       
       if(col == board.length){
           res.add(construct(board));
           return;
       }
      for(int row = 0; row < board.length; row++){
          if(leftrow[row] == 0 && upperDiagonal[board.length - 1 + col - row] == 0 &&
             downDiagonal[row + col] == 0){
              board[row][col] = 'Q';
              leftrow[row] = 1;
              upperDiagonal[board.length - 1 + col - row] = 1;
              downDiagonal[row + col] = 1;
              
              solve(col + 1 , board , res , leftrow , upperDiagonal , downDiagonal);
              
              board[row][col] = '.';
              leftrow[row] = 0;
              upperDiagonal[board.length - 1 + col - row] = 0;
              downDiagonal[row + col] = 0;
              
          }
      }
   }

    
     private List<String> construct(char[][] board) {
        List<String> ans = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
          return ans;
    }
}