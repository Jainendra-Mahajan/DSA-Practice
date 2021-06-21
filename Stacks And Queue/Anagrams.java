//  TC is O(N) for comparing all nodes at particular level
//  use queue to store nodes of curr level and comapare data using ArrayList
import java.util.*;
public class Anagram {
    static class Node {
        Node left , right;
        int data;
        
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
        
        static boolean areAnagrams(Node root1 , Node root2){
            
            if(root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null) return false;
            
            Queue<Node> q1 = new LinkedList<>();
            Queue<Node> q2 = new LinkedList<>();

            q1.add(root1);
            q2.add(root2);
            
            while(true){
                int n1 = q1.size();
                int n2 = q2.size();
                
                if(n1 != n2){
                    return false;
                }
                
                if(n1 == 0) break;
                    
                    ArrayList<Integer> al1 = new ArrayList<>();
                    ArrayList<Integer> al2 = new ArrayList<>();
                    
                while(n1 > 0){
                    Node node1 = q1.peek();
                    q1.remove();
                    
                    if(node1.left != null) q1.add(node1.left);
                    if(node1.right != null) q1.add(node1.right);
                    n1--;
                    
                    Node node2 = q2.peek();
                    q2.remove();
                    
                    if(node2.left != null) q2.add(node2.left);
                    if(node2.right != null) q2.add(node2.right);
                    
                    al1.add(node1.data);
                    al2.add(node2.data);
                    
                }
                
                Collections.sort(al1);
                Collections.sort(al2);
                
                if(!al1.equals(al2)) return false;
            }
            return true;
        }
    
	public static void main (String[] args) {
		 Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
       
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
       
          
        System.out.println(areAnagrams(root1, root2)?
                             "Yes" : "No");
	}
}