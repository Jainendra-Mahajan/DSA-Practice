/*
Tc is O(N).
S is O(2N) ~ O(N)
        max profit if sell is madat.    max profit if buy is mandot.            
                    ---------------><-----------------
                                   /\
                                  /  \            
                                 /    \          /\ 
                                /      \        /  \
                               /        \      /    \
                        /\    /          \    /      \
                       /  \  /            \  /        \
                      /    \/              \/
                     /      
                    /
                
                dpl------->                     <---------dpr    
    We will land on converging point where if we add both values we get 2 transaction profit.

*/


class Stocks {
	public static void main (String[] args) {
		int[] arr = {2, 30, 15, 10, 8, 25, 80};
		int n = arr.length;
		
		// Max profit if selling is madatory today
		int max_profit_sold_today = 0;
		int min_so_far = arr[0];
		
		int[] dpl = new int[n];
		
		for(int i = 1; i < n; i++){
		    
		    if(min_so_far > arr[i]){
		        min_so_far = arr[i];
		    }
		    max_profit_sold_today = Math.max(max_profit_sold_today , arr[i] - min_so_far);
		    
		    dpl[i] = max_profit_sold_today;
		}
		
			// Max profit if selling is madatory today
		int max_profit_Buy_today = 0;
		int max_so_far = arr[n - 1];
		
		int[] dpr = new int[n];
		
		for(int i = n - 2; i >= 0; i--){
		    if(max_so_far < arr[i]){
		        max_so_far = arr[i];
		    }
		    
		    max_profit_Buy_today = Math.max(max_profit_Buy_today , max_so_far - arr[i]);
		    dpr[i] = max_profit_Buy_today;
		}
		
		int ans = 0;
		
		for(int i = 0 ; i < n; i++){
		    ans = Math.max(ans , dpl[i] + dpr[i]);
		}
		
		System.out.println(ans); 
	}
}