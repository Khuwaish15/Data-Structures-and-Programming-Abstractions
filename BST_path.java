package CSE260;
//Java program to demonstrate 
//delete operation in binary
//search tree
import java.util.*;

class BinarySearchTree {
 /* Class containing left 
 and right child of current node
  * and key value*/
 class Node {
     int key;
     Node left, right, parent;

     public Node(int item)
     {
         key = item;
         left = right = parent = null;
     }
 }

 // Root of BST
 Node root;

 // Constructor
 BinarySearchTree() { root = null; }

 // This method mainly calls insertRec()
 void insert(int key) { root = insertRec(root, key); }

 /* A recursive function to 
    insert a new key in BST */
 Node insertRec(Node root, int key)
 {

     /* If the tree is empty,
       return a new node */
     if (root == null) {
         root = new Node(key);
         return root;
     }

     /* Otherwise, recur down the tree */
     if (key < root.key) {
         // root.left = insertRec(root.left, key);
         Node createdNode = insertRec(root.left, key);
         createdNode.parent = root;
         root.left = createdNode;
     }
     else if (key > root.key) {
         Node createdNode = insertRec(root.right, key);
         createdNode.parent = root;
         root.right = createdNode;
     }

     /* return the (unchanged) node pointer */
     return root;
 }

 // This method mainly calls InorderRec()
 void inorder() { inorderRec(root); }

 // A utility function to do inorder traversal of BST
 void inorderRec(Node root)
 {
     if (root != null) {
         inorderRec(root.left);
         System.out.print(root.key + " ");
         inorderRec(root.right);
     }
 }
 void backtrack(Node root)
 {
     while(root!=null)
     {
         System.out.print(root.key + " ");
         root = root.parent;
     }
 }

 // A utility function to do inorder traversal of BST
 void findLeaf(Node root)
 {
     if(root == null)return;
     if(root.left == null && root.right == null)
     {
         backtrack(root);
         System.out.print("\n");
         return;
     }
     if (root != null) {
         findLeaf(root.left);
         findLeaf(root.right);
     }
 }

 // Driver Code
 public static void main(String[] args)
 {
     BinarySearchTree tree = new BinarySearchTree();

     ArrayList<Integer> list = new ArrayList<Integer>();

     for(int i = 1 ; i <= 100 ; ++i)
     {
         list.add(i);
     }
     Collections.shuffle(list);

     // insert
     for(int i = 0 ; i < 100 ; ++i)
     {
         tree.insert((int)list.get(i));
     }

     tree.findLeaf(tree.root);

 }




}
