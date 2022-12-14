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
     Node left, right;

     public Node(int item)
     {
         key = item;
         left = right = null;
     }
 }

 // Root of BST
 Node root;

 // Constructor
 BinarySearchTree() { root = null; }

 // This method mainly calls deleteRec()
 void deleteKey(int key) { root = deleteRec(root, key); }

 /* A recursive function to 
   delete an existing key in BST
  */
 Node deleteRec(Node root, int key)
 {
     /* Base Case: If the tree is empty */
     if (root == null)
         return root;

     /* Otherwise, recur down the tree */
     if (key < root.key)
         root.left = deleteRec(root.left, key);
     else if (key > root.key)
         root.right = deleteRec(root.right, key);

     // if key is same as root's 
     // key, then This is the
     // node to be deleted
     else {
         // node with only one child or no child
         if (root.left == null)
             return root.right;
         else if (root.right == null)
             return root.left;

         // node with two children: Get the inorder
         // successor (smallest in the right subtree)
         root.key = minValue(root.right);

         // Delete the inorder successor
         root.right = deleteRec(root.right, root.key);
     }

     return root;
 }

 int minValue(Node root)
 {
     int minv = root.key;
     while (root.left != null) 
     {
         minv = root.left.key;
         root = root.left;
     }
     return minv;
 }

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
     if (key < root.key)
         root.left = insertRec(root.left, key);
     else if (key > root.key)
         root.right = insertRec(root.right, key);

     /* return the (unchanged) node pointer */
     return root;
 }

 Boolean search(Node node, int key) { 

     if (node == null) 
         return false; 
     Boolean status = false;
     if (key == node.key)
     return true;
     else
     if (key < node.key) 
         status = search(node.left, key); 
     else if (key > node.key) 
         status = search(node.right, key); 
     return status; 
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

 // Driver Code
 public static void main(String[] args)
 {
     final long startTime = System.nanoTime();

     BinarySearchTree tree = new BinarySearchTree();

     ArrayList<Integer> list = new ArrayList<Integer>();

     for(int i = 0 ; i < 500000 ; ++i)
     {
         int rand = (int) (Math.random()*500000)+1; 
         list.add(rand);
         //tree.root = tree.insert(tree.root,rand);
     }

     // insert
     for(int i = 0 ; i < 500000 ; ++i)
     {
         tree.insert((int)list.get(i));
     }

     // shuffle
     Collections.shuffle(list);

     // search
     for(int i = 0 ; i < 500000 ; ++i)
     {
         if(!tree.search(tree.root, list.get(i)))
         System.out.println("Error");
     }

     // shuffle
     Collections.shuffle(list);

     // delete
     for(int i = 0 ; i < 500000 ; ++i)
     {
         tree.deleteKey(list.get(i));
         // if(root == null)
         // System.out.println("Error");
     }




     final long duration = System.nanoTime() - startTime;

     System.out.println(duration);
 }



}
