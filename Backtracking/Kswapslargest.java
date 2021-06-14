class Solution
{
    
    //Function to find the largest number after k swaps.
    
    static String max;
    public static String findMaximumNum(String str, int k)
        {
               max = str;
            maximumHelper(str.toCharArray() , k);
            return max;
        }
        
        static void maximumHelper(char[] str , int k){
            
              if (String.valueOf(str).compareTo(max) > 0)
          max = String.valueOf(str); // if value is greater than 0 return true else false(CompareTo(N) function)
 
        
        
        if(k == 0) return;
        
            for(int i = 0; i < str.length - 1; i++){
                for(int j = i + 1; j < str.length; j++){
                    
                    if(str[j] > str[i]){
                        char temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                        
                        maximumHelper(str , k - 1);
                        
                        char c = str[i];
                        str[i] = str[j];
                        str[j] = c;
                    }
                }
            }
        }
}