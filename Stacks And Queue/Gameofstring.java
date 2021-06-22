// Time Complexity: O(k*logn)

class Gameofstring{
    
    static int minValue(String str, int k){
        
        int result = 0;
        
        int[] freq = new int[26]; 
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a']++;              // ASCII value
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0)
                pq.add(freq[i]);
        }
        
        //  Remove k  elements
        
        while(k > 0){
            pq.add(pq.poll() - 1);           // It will again add elements in reverseorder only because of pq.
            k--;
        }
        
        while(!pq.isEmpty()){
            result += Math.pow(pq.poll() , 2);
        }
        
        return result;
        
    }
}