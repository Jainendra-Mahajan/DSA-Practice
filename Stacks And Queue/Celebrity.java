// Use stack 
// fill all elements in stack
//pop two elements and push back that element which can be a potential celebrity
//Again check for that potential celebrity in that row and col.

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < arr.length; i++){
        st.push(i);
    }
        
        while(st.size() >= 2){
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1){      // if i knows j j can be celebrity so push j 
                st.push(j);
            }
            else {                   // if j knows i i can be celebrity so push i
                st.push(i);
            }
        }
    
    
    
    int temp = st.pop();           //store temp ans 
    
    for(int i = 0; i < arr.length; i++){
        if(i != temp){
            if(arr[i][temp] != 1 || arr[temp][i] != 0) return -1;
        }
    }
    return temp;
    }
}