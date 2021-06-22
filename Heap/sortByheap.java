// Time Complexity: O(N * Log(N)).
// Space Complexity O(1)

//  Intusion is make a max heap 
// move largest element of heap to last and heapify rest of arr.
// after heapify we will be left with another larger no. on top 
// Do the same with whole array
class sortByHeap
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        heapSort(arr , n);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int greatest = i;
        
        int left = 2 * i  + 1;
        int right = 2 * i  + 2;
        
        if(left < n && arr[left] >  arr[greatest]) greatest = left;
        if(right < n && arr[right] >  arr[greatest]) greatest = right;
    
        if(greatest != i){
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
            
            heapify(arr , n , greatest);
        }
        
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        int lastIdx = (n / 2) - 1;
        
        for(int i = lastIdx; i >= 0; i--){
            heapify(arr , n , i);
        }
        
        // sort the max heap 
        
        for(int i = n - 1; i >= 0; i--){
          int temp = arr[i];
          arr[i] = arr[0];
          arr[0] = temp;
          
          heapify(arr , i , 0);  // move largest to last and send rest to heapify 
        }                        // and again do the same and we will have sorted array
    }
 }
 
 
