// This runs as if we see stack top has '(' means there are no 
//oprands in b/w them so return true

// TC & SC - O(N)
import java.io.*;
import java.util.*;

class duplicateBrackets {
    
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    
    Stack<Character>  st = new Stack<>();
    for(int i = 0;  i <  str.length(); i++){
        char ch = str.charAt(i);
        
        if(ch == ')'){
            if(st.peek() == '('){
                System.out.println(true);
                return;
            }
            else {
                while(st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
        }
        else 
            st.push(ch);
        
    }
    System.out.println(false);
	    
	}
}