// Simply backtrack and solve the problem
// check for duplicates and remove first from set
// tc - ((2^t) * k)) Exponential
// Sc - dependent on combinations
class Solution
{
    
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
{

            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> curr  = new ArrayList<>();
            Set<Integer> set = new HashSet<>(A);
            A.clear();
            A.addAll(set);
            Collections.sort(A);
            
            findCombinations(A , B , 0 , curr , res);
            
            return res;
}
    static void findCombinations(ArrayList<Integer> arr, int sum ,int index, ArrayList<Integer> curr,  ArrayList<ArrayList<Integer>> res){
        
        if(sum == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = index ; i < arr.size(); i++){
            if(sum - arr.get(i) >=0 ){
                curr.add(arr.get(i));
                
                findCombinations(arr , sum - arr.get(i) , index , curr , res);
                
                curr.remove(arr.get(i));
            }
        }
    }
}