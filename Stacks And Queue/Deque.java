 // Construct a stack and queue with Dequeue
 
class DEQ {
    
    static class Deque{                   // Costruct DEQ
        int val;
        Deque next;
        Deque prev;
    }
    
    static class deque{
        private Deque head;
        private Deque tail;
        
        public deque(){
            head = tail = null;
        }
        
        
        boolean isEmpty(){
            if(head == null) return true;
            return false;
        }
        
        int size(){
            
            if(!isEmpty()){
            Deque temp = head;
            int length = 0;
            while(temp != null){
                length++;
                temp = temp.next;
            }
            return length;
        }
        return 0;
    }
    
    void insert_first(int element){
            Deque temp = new Deque();
            temp.val = element;
            
        if(head == null){
            tail = head = temp;
            temp.prev = null;
            temp.next = null;
            
        }
        else {
            head.prev = temp;
            temp.next = head;
            temp.prev = null;
            head = temp;
        }
    }
    
    void insert_last(int element){
        Deque temp = new Deque();
        temp.val = element;
         if(head == null){
            tail = head = temp;
            temp.prev = null;
            temp.next = null;
            
        }
        
        else {
            tail.next = temp;
            temp.next = null;
            temp.prev = tail;
            tail = temp;
        }
        
    }
     void remove_first(){
         if(!isEmpty()){
             
             head = head.next;
             head.prev = null;
             return;
         }
         System.out.print("List is Empty");
     }
     void remove_last(){
         
         if(!isEmpty()){
             
             tail = tail.prev;
             tail.next = null;
             return;
         }
         System.out.print("List is Empty");
     }
     void display(){
         if(!isEmpty()){
             Deque temp = head;
             while(temp != null){
                 System.out.print(temp.val + " ");
                 temp = temp.next;
             }
             return;
         }
          System.out.print("List is Empty");
     }
     
}
static class Stack
{
    deque d = new deque();
 
    // push to push element at top of stack
    // using insert at last function of deque
    public void push(int element)
    {
        d.insert_last(element);
    }
 
    // Returns size
    public int size()
    {
        return d.size();
    }
     
    // pop to remove element at top of stack
    // using remove at last function of deque
    public void pop()
    {
        d.remove_last();
    }
 
    // Display
    public void display()
    {
        d.display();
    }
}
 
// Class to implement queue using deque
static class Queue
{
    deque d = new deque();
     
    // enqueue to insert element at last
    // using insert at last function of deque
    public void enqueue(int element)
    {
        d.insert_last(element);
    }
 
    // dequeue to remove element from first
    // using remove at first function of deque
    public void dequeue()
    {
        d.remove_first();
    }
 
    // display
    public void display()
    {
        d.display();
    }
     
    // size
    public int size()
    {
        return d.size();
    }
}

	public static void main (String[] args) {
	// Object of Stack
    Stack stk = new Stack();
 
    // push 7 and 8 at top of stack
    stk.push(7);
    stk.push(8);
    System.out.print("Stack: ");
    stk.display();
 
    // For new line
    System.out.println();
     
    // pop an element
    stk.pop();
    System.out.print("Stack: ");
    stk.display();
 
    // For new line
    System.out.println();
 
    // Object of Queue
    Queue que = new Queue();
 
    // Insert 12 and 13 in queue
    que.enqueue(12);
    que.enqueue(13);
    System.out.print("Queue: ");
    que.display();
 
    // New line
    System.out.println();
     
    // Delete an element from queue
    que.dequeue();
    System.out.print("Queue: ");
    que.display();
 
    // New line
    System.out.println();
    System.out.println("Size of stack is " +
                       stk.size());
    System.out.println("Size of queue is " +
                       que.size());
	}
}