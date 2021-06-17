// TC - O(N)
// SC - O(N)
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long[] rb = new long[(int)n];
        
        Stack<Integer> st = new Stack<>();
        st.push(hist.length - 1);
        rb[hist.length - 1] = hist.length;
        
        for(int i = hist.length - 2; i >= 0; i--){
            while(st.size() > 0 && hist[st.peek()] >= hist[(int)i]){
                st.pop();
            }
            
            if(st.size() == 0) 
           rb[(int)i] = hist.length;
            
            else {
               rb[(int)i] = st.peek();
            }
            
            st.push(i);
        }
    
        long[] lb = new long[(int)n];
        
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        
        for(int i = 1;  i < hist.length; i++){
            while(st.size() > 0 && hist[st.peek()] >= hist[(int)i]){
                st.pop();
            }
            
            if(st.size() == 0) 
           lb[(int)i] = -1;
            
            else {
               lb[(int)i] = st.peek();
            }
            
            st.push((int)i);
        }
        
        long max = 0;
        
        for(int i = 0; i < hist.length; i++){
            long width = rb[(int)i] - lb[(int)i] - 1;
            long area = width * hist[i];
            if(area > max){
                max = area;
            }
        }
        
        return max;
    }
        
}
