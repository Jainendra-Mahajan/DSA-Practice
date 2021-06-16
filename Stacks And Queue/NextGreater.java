// store last values ans as -1 
// run reverse loop 
// and perform pop , update ans and push curr element as it can be greater for some 
// other elements also

// TC is O(n) used while in for loop but every element is pushed and pop once 

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<Long>();
        long[] ans = new long[n];
        
        ans[n - 1] = -1;
        st.push(arr[n - 1]);
        
        for(int i = n - 2; i >= 0; i--){
         
         while(st.size() > 0 && arr[i] >= st.peek()){           // for every condition
                                                                // do pop , update ans 
             st.pop();                                          //and push curr element
         }
         
         if(st.size() == 0)
         { 
             ans[i] = -1;
         }  
           else 
           {
               ans[i] = st.peek();
           }
           st.push(arr[i]);
        }
        return ans;
    } 
}
