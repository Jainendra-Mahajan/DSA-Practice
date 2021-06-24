// TC is O(N log N) log n to insert in a pq;
// SC is O(N)

// Intusion :  for even number the median is mid value of min and max / 2;
// eg - 1 2 3 4 5 6 median lies in 3 and 4 
// odd is the both parts are equally divided.
// so we mainly need max value from first part and min value of second part.
// we used Priority Queue.
import java.util.*;

class Median
{
    static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> right = new PriorityQueue<>();
    public static void insertHeap(int x)
    {
        if(left.isEmpty() || left.peek() >  x){
            left.add(x);
        }
        else {
            right.add(x);
        }
        
        balanceHeaps();
        getMedian();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if(left.size() > right.size() + 1){
           right.add(left.poll());
       }
       else if(right.size() > left.size() + 1){
           left.add(right.poll());
       }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(left.size() > right.size()){
            return ((double) left.peek());
        }
        
        else if(left.size() < right.size()){
            return ((double) right.peek());
        }
        
        else {
            return (double)((right.peek() + left.peek()) / 2);
        }
    }
    
}