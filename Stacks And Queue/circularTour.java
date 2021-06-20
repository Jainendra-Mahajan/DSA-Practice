//  Space is O(1) 
//  Time used is O(N) we have to move to every point 

class CircularTour
{
    
static class pair {
    int petrol;
    int distance;
    
   public pair(int petrol , int distance){
        this.petrol = petrol;
        this.distance = distance;
    }
}
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        
        int n = petrol.length;
        
	pair[] p = new pair[n];
	
	for(int i = 0; i < n; i++){
	    p[i] = new pair(petrol[i] , distance[i]);
	}
	
	int ans = possible(p ,n);
	return ans;
    }
    
    static int possible(pair[] p , int n){
        
        int start = 0;
        int end = 1;
        
        int currPetrol = p[start].petrol - p[start].distance;
        
        while(end != start || currPetrol < 0){           // Here we have to enter in anyone condition
            
            while(currPetrol < 0 && start != end){    // if currpetrol is -ve and we have remaining petrol pumps
                
                currPetrol -= p[start].petrol - p[start].distance;
                
                start = (start + 1) % n;
                
                if(start == 0)     //  if we reach here means there are no chances for answer return -1;
                return -1;
            }
            currPetrol += p[end].petrol - p[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }
}