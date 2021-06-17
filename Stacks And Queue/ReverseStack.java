// Reverse a stack using recursion calls

// first recursively store al char in call stack
// then call insert at bottom to insert char at last

import java.io.*;
import java.util.*;

class GFG {
    
    static Stack<Character> st =  new Stack<>();
    
    
    static void InsertAtBottom(char x){
    
    if(st.isEmpty()){
        st.push(x);
    }
    
    else {
        char ch = st.peek();
        st.pop();
        InsertAtBottom(x);
        
        st.push(ch);
    }
    }
    
    
    static void reverse(){
       if(st.size() > 0){
        
        char ch = st.peek();
        st.pop();
        reverse();
        
        
        InsertAtBottom(ch);
       }
        
    }
	public static void main (String[] args) {
	    st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
          
        System.out.println("Original Stack");
          
        System.out.println(st);
        
        reverse();
        
        System.out.println("Reversed Stack");
          
        System.out.println(st);
        
	}
}