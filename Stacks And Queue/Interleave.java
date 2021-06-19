//Only use stack to make a queue from 1 2 3 4 5 6 --------> 1 4 2 5 3 6

import java.util.*;

class interLeaveQ {
    
    static void interLeaveQueue(Queue<Integer> q){ //  1 2 3 4 5 6 
    
        Stack<Integer> st = new Stack<Integer>();
        int half = q.size() / 2;
        
        for(int i = 0; i < half; i++){
            st.push(q.poll());  //  3(T) 2 1
        }      
        
        while(!st.isEmpty()){
            q.add(st.pop());      // 4 5 6  3  2 1
        }
    
         for(int i = 0; i < half; i++){
            q.add(q.poll());  //  3 2 1 4 5 6
        }  
          for(int i = 0; i < half; i++){
            st.push(q.poll());  //   1(T) 2 3
        }     
        
        while(!st.isEmpty()){
            q.add(st.pop());
        q.add(q.poll());
        }
       

    }
	public static void main (String[] args) {
		 Queue<Integer> q = new java.util.LinkedList<>();
    q.add(11);
    q.add(12);
    q.add(13);
    q.add(14);
    q.add(15);
    q.add(16);
    q.add(17);
    q.add(18);
    q.add(19);
    q.add(20);
    interLeaveQueue(q);
    int length = q.size();
    for (int i = 0; i < length; i++) 
    {
        System.out.print(q.peek() + " ");
        q.poll();
    }
}
}