package CSE260;
import java.util.*;
class Node { 
    int key, height; 
    Node left, right, parent; 

    Node(int d) { 
        key = d; 
        height = 1; 
        left = right = parent = null;
    } 
} 

class AVLTree { 

    Node root; 

    // A utility function to get the height of the tree 
    int height(Node N) { 
        if (N == null) 
            return 0; 

        return N.height; 
    } 

    // A utility function to get maximum of two integers 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 

    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 

        // Perform rotation 
        x.right = y; 
        y.left = T2; 

        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 

        // Return new root 
        return x; 
    } 

    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 

        // Perform rotation 
        y.left = x; 
        x.right = T2; 

        // Update heights 
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 

        // Return new root 
        return y; 
    } 

    // Get Balance factor of node N 
    int getBalance(Node N) { 
        if (N == null) 
            return 0; 

        return height(N.left) - height(N.right); 
    } 

    Node insert(Node node, int key) { 

        /* 1. Perform the normal BST insertion */
        if (node == null) 
            return (new Node(key)); 

        if (key < node.key) {
            node.left = insert(node.left, key); 
        }
        else if (key > node.key) {
            node.right = insert(node.right, key); 
        }
        else // Duplicate keys not allowed 
            return node; 

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), 
                            height(node.right)); 

        /* 3. Get the balance factor of this ancestor 
            node to check whether this node became 
            unbalanced */
        int balance = getBalance(node); 

        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 

        // Right Right Case 
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 

        // Left Right Case 
        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        // Right Left Case 
        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 

        /* return the (unchanged) node pointer */
        return node; 
    } 


    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every node 
    void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
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

    void updateParent(Node root)
    {
        if(root == null)return;
        if(root.left != null)
        {
            root.left.parent = root;
            updateParent(root.left);
        }
        if(root.right != null)
        {
            root.right.parent = root;
            updateParent(root.right);
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
    
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        AVLTree tree = new AVLTree(); 

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < 100 ; ++i)
        {
            int rand = (int) (Math.random()*100)+1; 
            list.add(rand);
        }

        // insert
        for(int i = 0 ; i < 100 ; ++i)
        {
            tree.root = tree.insert(tree.root,(int)list.get(i));
            tree.updateParent(tree.root);
        }

        tree.findLeaf(tree.root);

    }


}
