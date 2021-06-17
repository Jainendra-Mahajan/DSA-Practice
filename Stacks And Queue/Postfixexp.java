class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String str)
    {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(Character.isDigit(ch)){
                st.push(ch - '0');
            }
            
            else {
                int v2 = st.pop();
                int v1 = st.pop();
                
                switch(ch){
                    case '+' : 
                        st.push(v1 + v2);
                        break;
                        
                    case '-' : 
                        st.push(v1 - v2);
                        break;
                        
                    case '*' : 
                        st.push(v1 * v2);
                        break;
                        
                    case '/' : 
                        st.push(v1 / v2);
                        break;
                }
            }
        }
        return st.pop();
    }
}