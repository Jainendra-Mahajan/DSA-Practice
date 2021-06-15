public class MyStack {

    private int size;
    private long[] stackArray;
    private int top;
    
    public MyStack(int s){
        size = s;
        stackArray = new long[size];
        top = -1;
    }
    
    public void push(long k){
         top++;
        stackArray[top] = k;
       
    }
    
    public long pop(){
        return stackArray[top--];
    }
    public long peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public  boolean isFull(){
        return (top == size - 1);
    }
    
	public static void main (String[] args) {
		MyStack st = new MyStack(5);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
	
		while(!st.isEmpty()){
		    long val = st.pop();
		    System.out.print(val + " ");
		}
	}
}