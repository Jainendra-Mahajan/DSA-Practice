//TC is O(NlogN)
//SC is O(N).
// Binary search approach.


class MINMAXRemoval{
	
    static int removals(int arr[], int n, int k){
        
        Arrays.sort(arr);
        
        int minRemovals = n - 1;
        
        for(int i = 0; i < n; i++){
            
            int j = search(arr[i] + k , i, n  ,arr);
            
            if(j != -1)
            minRemovals = Math.min(minRemovals , n-(j - i + 1));  // Find that elemrnt  which is less than equal to arr[i] + k. find the index substract rest of length from j - i.
        }
        
        return minRemovals;
    
    }
    static int search(int key , int i , int n , int[] arr){
        
        
        int start = i + 1;
        int end = n -1 ;
       
        int idx = -1;
        
        while(start < end){
            
             int mid = start + (end - start) / 2;
             
            if(arr[mid] <= key){
                idx = mid;
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return idx;
    }
    
    
    public static void main(String args[])
    {
        int a[] = { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
        int n = a.length;
        int k = 4;
        
        System.out.println(removals(a, n, k));
    }
    }
    
    
    