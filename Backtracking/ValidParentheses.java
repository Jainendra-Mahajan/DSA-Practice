// Use a stack to check minimum removals
// USe backtracking to check every char in string that
// if we remove that particular char can we get a valid string
// if we get valid string after doing min removals store in res hashset

class Solution {
    List<String>  res = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
        int min = minRemoval(s);
        Set<String> set = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        
        removeInValidParentheses(s , set , visited ,  min);
        return res;
        
    }
    
     void removeInValidParentheses(String s , Set<String> set , Set<String> visited ,  int min){
        
         
         if(visited.contains(s)){               
             return;
         }
         visited.add(s);        // store every removed char string to not get repeated string
         
    
        if(min == 0){
            
            int minRem = minRemoval(s);
            
            if(minRem == 0){
               res.add(s);
            }
             return;
        }
            
           
        
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0 , i);
            String right = s.substring(i + 1);
            
                removeInValidParentheses(left + right , set , visited ,  min - 1);
            
        }
    }
    
    static int minRemoval(String s){
        Stack<Character> st = new Stack<>();
       
        for(int i = 0; i < s.length(); i++){
             char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            
            else if(ch == ')'){
               if(st.size() == 0)
                   st.push(ch);
                
            else if(st.peek() == ')')
                st.push(ch);
            
            else if(st.peek() == '(') 
                st.pop();
            
            
        }
    }
        return st.size();
    }
}