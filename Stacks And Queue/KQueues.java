// Time complexities of enqueue() and dequeue() is O(1).

public class KQueues {
 
    int k;
    int n;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;
     
    KQueues(int k, int n){
         
        // Initialize n and k, and allocate memory for all arrays
        this.k = k;
        this.n = n;
        this.arr = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];
         
        // Initialize all queues as empty
        for(int i= 0; i< k; i++) {
            front[i] = rear[i] = -1;
        }
         
        // Initialize all spaces as free
        free = 0;
        for(int i= 0; i< n-1; i++) {
            next[i] = i+1;
        }
        next[n-1] = -1;
         
         
    }
	public static void main (String[] args) {
		 // Let us create 3 queue in an array of size 10
        int k = 3, n = 10;
        KQueues ks=  new KQueues(k, n);
        
         
        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);
       
        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);
       
        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
         
        System.out.println("Dequeued element from queue 2 is " +
                                ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " +
                                ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " +
                                ks.dequeue(0) );
	}
	
	private boolean isEmpty(int que){
	    return front[que] == -1;
	}
	private boolean isFull(int que){
	    return free == -1;
	}
	
	private void  enqueue(int data , int q)
	{
	    
	    if(isFull(q)){
	        System.out.println("queue OverFlow");
	        return;
	    }
	    
	    int nextFree = next[free];
	    
	    if(isEmpty(q)){
	        front[q] = rear[q] = free;
	    }
	    
	    else {
	        next[rear[q]] = free;        // Here  next[rear] tell that its next value is stored at free position
	        rear[q] = free;
	    }
	    
	    next[free] = -1;
	    
	    arr[free] = data;
	    
	    free = nextFree;
	}
	
	 private int dequeue(int q) {
	     if(isEmpty(q)){
	     System.out.println("queue UnderFlow");
	         return -1;
	     }
	     
	     int frontIdx = front[q];
	     front[q] = next[frontIdx];
	     
	     
	     next[frontIdx] = free;         // Fill the free spot  first and 
	     free = frontIdx;               // store next of that free spot val in next[frontIdx]
	     
	     return arr[frontIdx];
	     
	 }
}