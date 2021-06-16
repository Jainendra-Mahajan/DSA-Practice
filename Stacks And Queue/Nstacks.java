// Time complexities of operations push() and pop() is O(1).

class Nstacks {
    
    static class MyStack{
        int[] arr;                   // Stores values of stack
        int[] top;                   // Stores top index of stack
        int[] next;                 //  Stores next values index 
         
         int n , k;
         int free;            // Free index position
         
         MyStack(int k1 , int n1){
             k = k1;
             n = n1;
             arr = new int[n];
             top = new int[k];
             next = new int[n];
             
             free = 0;
             
             for(int i = 0; i < k; i++)
                 top[i] = -1;               // Initialize all stacks as empty
             
             
             for(int i = 0; i < n; i++)
                 next[i] = i + 1;          // Initialize all spaces as free
             
             next[n - 1] = -1;
         }
         
         boolean isFull(){
             return (free == -1);
         }
         
         
         void push(int data , int stack){
             
             if(isFull()){
                 System.out.println("Stack Overflow");
                 return;
             }
             int i = free; // get the free index position
             
             arr[i] = data; // insert the data
             
             free = next[i]; //  update next free index fro next[]
             
             next[i] = top[stack];    // store the index of next value of new data 
             
             top[stack] = i; // update top by curr index;
             
             
         }
         
         boolean isEmpty(int st){
             return (top[st] == -1);
         }
         int pop(int st){
             if(isEmpty(st)){
                 System.out.println("Stack UnderFlow");
                 return -1;
             }
         
             int i = top[st]; // get curr top index
             
             top[st] = next[i]; // assign new top
             
             next[i] = free;  // store currently present free index at next[i]
             
             free = i; // make free assign to the newly free index 
             
             return arr[i];
                    }
    }
    
	public static void main (String[] args) {
		 int k = 3, n = 10;
          
        MyStack ks = new MyStack(k, n);
  
        ks.push(15, 2);
        ks.push(45, 2);
  
        
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
  
        
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}