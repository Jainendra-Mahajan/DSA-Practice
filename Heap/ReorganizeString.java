// Use map to store  freq of character
// make maxheap of map generics 
//use cprev to store the freq value if its greater than 0 and if prev
// is not null then add it to maxheap to process again. 
import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        Map<Character , Integer> hm  = new HashMap<Character , Integer>();
        
        for(char ch: s.toCharArray())
            hm.put(ch ,hm.getOrDefault(ch , 0) + 1);
    
PriorityQueue<Map.Entry<Character , Integer>> maxHeap = new PriorityQueue<>((x , y) -> (y.getValue() - x.getValue()));
        maxHeap.addAll(hm.entrySet());
        
        Map.Entry<Character , Integer> prev = null;
        
        StringBuilder res = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            
            Map.Entry<Character , Integer> curr = maxHeap.poll();
            res.append(curr.getKey());
            
            curr.setValue(curr.getValue() - 1);
            
            if(prev != null){
                maxHeap.add(prev);
            }
            
            if(curr.getValue() > 0){
                prev = curr;
            }
            else {
                prev = null;
            }
            
        }
        
        return res.length() == s.length() ? res.toString() : ""; 
    }
}