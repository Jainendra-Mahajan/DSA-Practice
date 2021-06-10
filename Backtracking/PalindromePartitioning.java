// We have to just do partiotioning at every postition and check palindrome
// aab ----> a|"ab" --> a|a|"b" -- > a|a|b| 
// while doing backtracking we remove the char form path list

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        function(s , 0 , path , res);
        return res;
    }
    
    void function(String s , int index , List<String> path , List<List<String>> res){
        if(index == s.length()){
           
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s , index , i)){
                
                path.add(s.substring(index , i + 1));
                function(s , i + 1 , path , res);
                path.remove(path.size() -1);
            }
        }
    }
    
    boolean isPalindrome(String s , int start , int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}