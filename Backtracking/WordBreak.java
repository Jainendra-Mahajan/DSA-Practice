// Used backtracking just we have to check possibilities from every word;

class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> res = new ArrayList<String>();
        
        wordHelper(n , s, dict ,  res , "");
        
        
        return res;
    }
    
    static void wordHelper(int n , String s , List<String> dict , List<String> res , String ans){
        
        for(int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0 , i);
            
            if(dict.contains(prefix)){
                
                if(i == s.length()){
                     ans += prefix;
                     res.add(ans);
                     return ;
                }
               
                wordHelper(n, s.substring(i , s.length()) , dict ,res ,  ans + prefix + " ");
            }
        }
    }
}