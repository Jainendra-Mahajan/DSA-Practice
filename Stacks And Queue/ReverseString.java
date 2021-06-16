class Solution {
    
    public String reverse(String S){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            st.push(ch);
        }
    
    String res = "";
    while(st.size() != 0){
        char ch = st.peek();
        st.pop();
        res += ch;
    }
    return res;
    }

}