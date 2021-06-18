// Push -1 for base case ie. if we substract from we will get an valid index
// push index in st , if ')' pop it and check for valid length from curr idx
// to st.peek() element.

// TC and SC is O(N)

class Solution {
    static int findMaxLen(String S) {
   Stack <Integer> st =  new Stack<>();
   
   st.push(-1);
   int res = 0;
   for(int i = 0; i < S.length(); i++){
       char ch = S.charAt(i);
       
       if(ch == '('){
           st.push(i);
       }
       
       else {
           if(!st.isEmpty()){
               st.pop();
           }
           if(!st.isEmpty()){
            
           
               res = Math.max(res , i - st.peek());
           }
               
           else{
               st.push(i);
           }
       }
       
   }
   return res;
    }
};