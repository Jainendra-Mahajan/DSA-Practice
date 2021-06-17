// TC is always n^2 

public Stack<Integer> sort(Stack<Integer> s)
	{
		reverse(s);
		return s; 
	}
	
	static void reverse(Stack<Integer> s){
	    if(s.size() > 0){
	        
	        int x = s.peek();
	        s.pop();
	        reverse(s);
	        
	        sort(s, x);
	    }
	}
	    
	    static void sort(Stack<Integer> s , int x){
	        if(s.size() == 0 || s.peek() <= x){
	            s.push(x);
	        }
	        
	        if(s.peek() > x){
	            int temp = s.peek();
	            s.pop();
	             sort(s , x);
	             
	             s.push(temp);
	        } 
	    }
}