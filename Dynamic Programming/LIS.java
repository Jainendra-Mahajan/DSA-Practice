/*TC is O(N) */

class LIS {
    static class Node{
        int data , lis;           // lis stores the answer works as Dp here 
        Node left , right;
        
        public Node(int data){
            this.data = data;
            lis = 0;
        }
    }
    static int lis(Node root){
        
        if(root == null)return 0;
        
        if(root.lis != 0) return root.lis; // Memoization.
        
        if(root.left == null && root.right == null){       // This case for single node if we go include part then it will 1 only so to reduce time we write this base case.
            return root.lis = 1;
        }
        
        int curr_exc = lis(root.left) + lis(root.right);       // Max(1 + lis of grandchild node) and exclude curr element cal lis of left + right
        
        int curr_inc = 1;    
        
        if(root.left != null){
            curr_inc += (lis(root.left.left) + lis(root.left.right));    
        }
        if(root.right != null){
            curr_inc += (lis(root.right.left) + lis(root.right.right));
        }
        
        return root.lis = Math.max(curr_inc , curr_exc);
        
    }
	public static void main (String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        
        System.out.println("LIS of Tree is " + lis(root));
		
	}
}