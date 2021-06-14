class subset
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
        if(k==0){
        return false;
    }
	int sum = 0;
	
	for(int i = 0; i < n; i++){
	    sum += a[i];
	}
	
	if(sum % k != 0) return false;
	
	
	
	boolean visited[] = new boolean[n];
	   
	   return partition(0 , a , visited , k , 0 , sum / k);
    }
    static boolean partition(int start , int[] arr , boolean[] used , int k , int curr , int target){
        
        
        if(k  == 1){
            return true;
        }
        
        if(curr == target){
            return partition(0 , arr , used , k - 1 , 0 , target);
        }
        for(int i = start ; i < arr.length; i++){
            if(!used[i]){
                used[i] = true;
                if(partition(i + 1 , arr , used , k , curr + arr[i] , target)) {
                    return true;
                }
                
                used[i] = false;
            }
        }
    return false;
    }
}
 
