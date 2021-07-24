//This is basic structure to find permutations / subset problems using backTracking.
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list , new ArrayList<>(),nums);
        return list;
    }
    
    void backtrack(List<List<Integer>> list , List<Integer> temp, int[] arr){
        // Base case
        if(temp.size() == arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(temp.contains(arr[i])) continue; // number present in temp list skip it.
            temp.add(arr[i]);
            backtrack(list , temp , arr);
            temp.remove(temp.size() - 1);    // remove curr element from temp list 
                                            //to try more combinations
        }
    }
}