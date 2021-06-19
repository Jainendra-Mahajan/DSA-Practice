// Time complexity of enQueue(), deQueue() operation is O(1)

import java.util.ArrayList;

class CircularQueue {
    private int size , front , rear;
    
    private ArrayList<Integer> al = new ArrayList<>();
    
     CircularQueue(int size){
        this.size = size;   
        this.front = this.rear =  -1;
    }
    
    public void enQueue(int data){
        // check for full condition
        
        if((front == 0 && rear == size - 1) ||
        (rear == (front - 1) % (size - 1))) {
        // % for again getting back to starting ArrayList
        System.out.println("Queue is Full");
        }
    
    
     // empty condotion
     
     else if(front == - 1 && rear == -1){
         front = rear = 0;
         al.add(rear , data);
     }
     
     // front is not at 0 and rear at last position;
     
     else if(front != 0 && rear == size - 1){
         rear = 0;
         al.set(rear , data);
     }
     
     else {
         rear += 1;
         
         if(front < rear){
             al.add(rear , data);
         }
         else {
             al.set(rear , data);
         }
     }
}

public int deQueue(){
    int temp;
    
    if(front == -1){
        System.out.println("Queue is Empty");
        return -1;
    }
    
    temp = al.get(front);
    
    if(front == rear){
        front = rear = -1;
    }
    
    else if(front == size - 1){
        front = 0;
    }
    
    else {
        front += 1;
    }
    return temp;
}

public void displayQueue(){
    if(front == -1){
        System.out.println("Queue is Empty");
        return;
    }
     System.out.print("Elements in the " +
                     "circular queue are: ");
    if(rear > front){
        for(int i = front; i <= rear; i++){
            System.out.println(al.get(i) + " ");
        }
    }
    
    else {
        for(int i = front; i < size; i++){
            System.out.println(al.get(i) + " ");
        }
        for(int i = 0; i <= rear; i++){
            System.out.println(al.get(i) + " ");
        }
        
    }
}
	public static void main (String[] args) {
		CircularQueue q = new CircularQueue(5);
		
	    q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);
        
        q.displayQueue();
        
        int x = q.deQueue();
        
        if(x != -1)
    {
        System.out.print("Deleted value = ");
        System.out.println(x);
    }
    
    x = q.deQueue();
    
    q.enQueue(9);
    q.enQueue(20);
    q.enQueue(5);
     
    q.displayQueue();
     
    q.enQueue(20);
	}
}