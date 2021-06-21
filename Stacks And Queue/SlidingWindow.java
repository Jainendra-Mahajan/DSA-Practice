
// TC is O(N)
// SC is O(K)

class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        long[] ans = new long[N - K + 1];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        
        // add -ve elements till k
        
        int i;
        
        for(i = 0; i < K; i++){
            if(arr[i] < 0) 
            q.add(i);
        }
        
        for(; i < N ; i++){
            
            if(!q.isEmpty()){
                
                ans[idx] = arr[q.peek()];
                idx++;
            }
            else {
                ans[idx] = 0;
                idx++;
            }
            
            while(!q.isEmpty() && q.peek() < (i - K + 1)){ // if the index fits in current window
                q.remove();     // adding 1 to check for another index
            }
            
            if(arr[i] < 0) q.add(i);
        }
        
        if(!q.isEmpty())  ans[idx] = arr[q.peek()];
        else  ans[idx] = 0;
        
        return ans;
    }
}