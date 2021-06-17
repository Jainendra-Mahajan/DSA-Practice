// TC i s O(n log n) for sorting
// space is O(n) for stack which can be avoided

import java.util.*;

    class pair {
        int start , end;
        
        pair(int start , int end){
            this.start = start;
            this.end = end;
        }
    }
    
    class Merge {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i = 0; i < n; i++){
		    arr1[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
		    arr2[i] = sc.nextInt();
		}
		
		pair[] p = new pair[n];
		for(int i = 0; i < n; i++){
		    p[i] = new pair(arr1[i],  arr2[i]);
		}
		
		merge(p);
		
		
	}
	
	static void merge(pair[] arr){
	    if(arr.length == 0) return;
	    
	    Stack<pair> st = new Stack<>();
	    Arrays.sort(arr , new Comparator<pair>(){
	       
	       @Override 
	       public int compare(pair p1 , pair p2){
	           return p1.start - p2.start;
	       } 
	    });
	    
	    st.push(arr[0]);
	    
	    for(int i = 0; i < arr.length; i++){
	        
	         if(st.peek().end < arr[i].start) {
	            st.push(arr[i]);
	        }
	        else if(st.peek().end < arr[i].end){
	            st.peek().end = arr[i].end;
	        }
	    }
	    
	    while(!st.isEmpty()){
	        pair t = st.pop();
	        System.out.println("["+t.start+","+ t.end+"] ");
	    }
	}
	
}