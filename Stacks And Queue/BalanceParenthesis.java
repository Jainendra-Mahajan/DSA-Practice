//TC - O(n)
//SC - O(n) stack

class Solution
{
    
    static boolean ispar(String str)
    {
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }
            
            else if(ch == '}'){
                if(st.size() == 0) return false;
                else if(st.peek() == '(' || st.peek() == '[') return false;
                else st.pop();
                
            }
            else if(ch == ')'){
                    if(st.size() == 0) return false;
                else if(st.peek() == '{' || st.peek() == '[') return false;
                else st.pop();
            }
            else if(ch == ']'){
                    if(st.size() == 0) return false;
                else if(st.peek() == '{' || st.peek() == '(') return false;
                else st.pop();
                
            }
           
          
        }
       
           if(st.isEmpty()) return true;
           
           return false;
    }
}