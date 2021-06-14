/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    static void printMatrix(int[][] mat, int m , int n , int i , int j , int[] path , int idx){
         
         if(i >= m || j >= n) return;
         
        path[idx] = mat[i][j];
        
        if(i == m - 1 && j == n - 1){
             for(int l = 0; l < path.length; l++){
              System.out.print(path[l] + " ");
          }
          System.out.println();
            return;
            
        }
       
        printMatrix(mat , m , n , i + 1 , j ,path , idx + 1);
        printMatrix(mat , m , n , i , j + 1 ,path , idx + 1);
        
    }
public static void main(String[] args)
    {
        int m = 2;
        int n = 3;
        int mat[][] = { { 1, 2, 3 },
                        { 4, 5, 6 } };
        int maxLengthOfPath = m + n - 1;
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }
}