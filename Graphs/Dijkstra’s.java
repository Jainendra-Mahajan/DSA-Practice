// TC is O(N log N) for PriorityQueue operations
// SC is O(N) + O(N)  ~ O(N)

// Make dist array store biggest value 
// Use PriorityQueue as min heap
// Comparator is used to keep min weight at top.


import java.util.*; 

class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    
    int getWeight() { return weight; }
    
    @Override
    public int compare(Node n1 , Node n2){
        if(n1.weight >  n2.weight) 
        return 1;
        
         if(n1.weight < n2.weight)
        return -1;
        
        return 0;
    }
}

class Main
{
    void shortestPath(int idx , ArrayList<ArrayList<Node>> adj , int V){
        int[] dist = new int[V];
        for(int i = 0 ; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[idx] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V , new Node());
        pq.add(new Node(idx , 0));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            for(Node it : adj.get(curr.getV())){
                if(dist[curr.getV()] + it.getWeight() < dist[it.getV()]){
                    dist[it.getV()] = dist[curr.getV()] + it.getWeight();
                    
                    pq.add(new Node(it.getV() , dist[it.getV()]));
                }
            }
        }
    
        for(int i = 0 ; i < V; i++)
        System.out.print(dist[i] + " ");
    }
    
    public static void main(String args[])
    {
        int n = 6;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node>());
			
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));
		
		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));
		
		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));
		
		Main obj = new Main(); 
		obj.shortestPath(0, adj, n); 
		
    }
}