 // Convert the list to ascending order and then change the values one by one visiting each 
 //node
import java.util.*;



class BSTtoMinHeap {
    public static class Node {
        Node left , right;
        int data;
        
        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    
    public static void convertToMinHeap(Node root){
        
        ArrayList<Integer> al = new ArrayList<>();
        
        bstToArray(root , al);
        arrayToMinHeap(root , al);
    }
    
    static void bstToArray(Node root , ArrayList<Integer> arr){
        if(root == null) return;
        
        bstToArray(root.left , arr);
        
        arr.add(root.data);
        
        bstToArray(root.right , arr);
        
    }
    
        static int idx = 0;
    static void arrayToMinHeap(Node root , ArrayList<Integer> al){
        
        if(root == null) return;
        
        root.data = al.get(idx++); // Elements are already sorted just change the values
        
        arrayToMinHeap(root.left , al);
        
        arrayToMinHeap(root.right , al);
    }
    
    static void preOrder(Node root){
        if(root == null) return;
        
        System.out.println(root.data + " ");
        
        preOrder(root.left);
        preOrder(root.right);
    }
	public static void main (String[] args) {
	 // BST formation
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);
     
    System.out.print("Preorder Traversal Before Conversion :" +"\n");
    preOrder(root);
    convertToMinHeap(root);
     
    System.out.print("\nPreorder Traversal After Conversion :" +"\n");
    preOrder(root);
	}
}