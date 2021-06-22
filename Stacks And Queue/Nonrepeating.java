import java.util.*;

class NonRepeating
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q = new LinkedList<>();
       StringBuilder sb = new StringBuilder("");
        int[] freq = new int[26];
        
        for(int i = 0; i < A.length(); i++){
            
            char ch = A.charAt(i);
            
            q.add(ch);
            freq[ch - 'a']++;
            
            while(!q.isEmpty()){
                
            if(freq[q.peek() - 'a'] > 1)
                q.poll();
            
            else break;
            }
            
            if(q.isEmpty()){
               sb.append("#");
            }
            else sb.append(q.peek());
        }
        
        return sb.toString();
    }
}