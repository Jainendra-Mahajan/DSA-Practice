/*package whatever //do not write package name here */

//TC will be O(N) once we are reaching every element

import java.util.*;

class GFG {
    
    static int SumOfKsubArray(int[] arr , int k){
        int sum = 0;
        
        Deque<Integer> greatest = new LinkedList<>();
        Deque<Integer> small = new LinkedList<>();
        
        int i = 0;
        for( i = 0 ; i < k; i++){
            
            while(!small.isEmpty() && arr[small.peekLast()] >= arr[i]){
                small.removeLast();
            }
            while(!greatest.isEmpty() && arr[greatest.peekLast()] <= arr[i]){
                greatest.removeLast();
            }
            
            greatest.add(i); // Add curr i for future elements
            small.add(i);
        }
        
        for(;i < arr.length; i++){
            
            sum += arr[small.peek()] + arr[greatest.peek()]; // calc sum
            
            while(!small.isEmpty() && small.peek() <= i - k) 
                small.removeFirst();     // limit check
            
            while(!greatest.isEmpty() && greatest.peek() <= i - k) 
                greatest.removeFirst();
            
            
             while(!small.isEmpty() && arr[small.peekLast()] >= arr[i])
                small.removeLast();
            
            while(!greatest.isEmpty() && arr[greatest.peekLast()] <= arr[i])
                greatest.removeLast();
            
            
            greatest.add(i);
            small.add(i);
        }
        
        sum += arr[small.peek()] + arr[greatest.peek()];
        
        return sum;
    }
	public static void main (String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int n = sc.nextInt();
	 
	 int[] arr = new int[n];
	 for(int i = 0 ; i < n; i++){
	     arr[i] = sc.nextInt();
	    
	 }
	 int k = sc.nextInt();
        int sum = SumOfKsubArray(arr, k);
        System.out.println(sum);
	}
}