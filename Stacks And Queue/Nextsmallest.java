
import java.util.*;

class NextSmallest {
    static void printNSE(int[]  arr , int n){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[n - 1] = -1;
        st.push(arr[n-1]);
        
        for(int i = n - 2; i >= 0; i--){
            if(st.isEmpty()){
                ans[i] = -1;
            }
            
           else if(!st.isEmpty() && st.peek() < arr[i]){
               ans[i] = st.peek();
           }
           
           else if(!st.isEmpty() && st.peek() >= arr[i]){
               while(!st.isEmpty() && st.peek() >= arr[i]){
                   st.pop();
               }
               
               if(st.isEmpty())
                   ans[i] = -1;
               
               else ans[i] = st.peek();
               
        }
            st.push(arr[i]);
    }
    
    for(int i = 0; i < n; i++){
        System.out.println(ans[i] + " ");
    }
    }
	public static void main (String[] args) {
		  int arr[] = { 11, 13, 21, 3};
        int n = arr.length;
        printNSE(arr, n);
	}
}