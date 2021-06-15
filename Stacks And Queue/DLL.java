// TC is O(1);
// We perform all,operations and delete mid element is done in O(1) time

public class DLL {
    class DLLNode {
        DLLNode prev;
        DLLNode next;
        int data;
        
        DLLNode(int d){
            data = d;
        }
    }
    
    class MyStack{
        DLLNode head;
        DLLNode mid;
        int count;
    }
        MyStack createStack(){
            MyStack s = new MyStack();
            s.count = 0;
            return s;
        }
    
    
    void push(MyStack s , int new_Data){
        DLLNode newNode = new DLLNode(new_Data); // New node created
        
        newNode.prev = null; // Adding new node at the last

        newNode.next = s.head; // Join new node link to prev head
        
        s.count += 1;
        
        if(s.count == 1) { 
        s.mid = newNode;
    }
    
    else {
        s.head.prev = newNode;
        
        if(s.count % 2 != 0) 
        s.mid = s.mid.prev;
    }
    
    s.head = newNode;
}

int pop(MyStack s){
    if(s.count == 0) {
        System.out.println("Stack is Empty");
        return -1;
    }
    DLLNode head = s.head;
    int item = head.data;
    s.head = head.next;
    
    if(s.head != null){
        s.head.prev = null;
    }
    
    s.count-=1;
    
    if(s.count % 2 != 0) 
    s.mid = s.mid.next;
    
    return item;
    
}

void deleteMiddle(MyStack s){
    if(s.count == 1) {
        s.mid = null;
        s.count -= 1;
        System.out.println("Stack is Empty");
    }
    
    if(s.count % 2 == 0){
        int delData = s.mid.data;
        s.mid = s.mid.prev;
        s.mid.prev.next = s.mid.next;
        s.mid.next.prev = s.mid.prev;
        System.out.println("Deleted Element was " + delData);
    }
    else {
        int delData = s.mid.data;
        s.mid = s.mid.next;
        s.mid.prev.next = s.mid.next;
        System.out.println("Deleted Element was " + delData);
    }
    
    
}

int Middle(MyStack s){
    if(s.count == 0) {
        System.out.println("Stack is Empty");
        return -1;
    }
    
    return s.mid.data;
}
	public static void main (String[] args) {
		DLL ob = new DLL();
        MyStack ms = ob.createStack();
        ob.push(ms, 11);
        ob.push(ms, 22);
        ob.push(ms, 33);
        ob.push(ms, 44);
        ob.push(ms, 55);
        ob.push(ms, 66);
        ob.push(ms, 77);
 
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Middle Element is "
                           + ob.Middle(ms));
        ob.deleteMiddle(ms);
        System.out.println("Middle Element is "
                           + ob.Middle(ms));
	}
}