class GfG{
    
   
    
	public void push(int a,Stack<Integer> st)
	{
	    st.push(a);
	}
	public int pop(Stack<Integer> st)
        {
           
           return st.pop();
	}
	public int min(Stack<Integer> st)
        {
            int minVal = Integer.MAX_VALUE;
            
            while(st.size() !=0){
                int temp = st.pop();
                if(temp < minVal) minVal = temp;
            }
           return minVal;
	}
	public boolean isFull(Stack<Integer>st, int n)
        {
           if(st.size() == n) return true;
           return false;
	}
	public boolean isEmpty(Stack<Integer>st)
        {
           if(st.size() == 0)return true;
           return false;
	}
}