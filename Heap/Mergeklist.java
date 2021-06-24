// Use minheap to merge data;
// TC is O(n * k logk)
// SC is O(k)

import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class mergeList
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int k)
    {
       Node head = null , last = null;
       
       
       PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
        
        @Override 
       public int compare(Node a , Node b){
            return a.data - b.data;
        }
       });
       
       for(int i = 0; i < k; i++)
         pq.add(arr[i]);
       
       while(!pq.isEmpty()){
           Node top = pq.peek();
           pq.remove();
           
           if(top.next != null){
               pq.add(top.next);
           }
           
           if(head == null){
               head = top;
               
               last = top;
           }
           
           else{
               last.next = top;
               last = top;
           }
          
       }
       
       return head;
    }
}
