/*package whatever //do not write package name here */

import java.io.*;

class MyQueue {
    private int capacity;
    private long[] arr;
    private int front;
    private int rear;
    private int count;
    
    public MyQueue(int n){
        capacity = n;
        arr = new long[capacity];
        front = 0;
        rear = 0;
        count = 0;
    }
    
    public void push(int num){
        if(count == capacity) return;
        arr[rear % capacity] = num;
        rear++;
        count++;
    }
    
    public void pop(){
        if(count == 0 )return;
        
        arr[front % capacity] = -1;
        front++;
        count--;
    }
    
    public long top(){
        if(count == 0)return -1;
         return arr[front];
    }
    
    public void print(){
        for(int i = front ; i < rear ; i++){
            System.out.print(arr[i%capacity] + " ");
        }
    }
    
	public static void main (String[] args) {
		MyQueue q = new MyQueue(5);
		
		q.push(3);
		q.push(2);
		q.push(1);
		q.push(8);
		q.push(6);
		q.push(7);
		q.pop();
		
		// q.pop();
		// q.push(2);
		
		System.out.println(q.top());
		
		q.print();
	}
}