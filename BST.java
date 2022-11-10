package CSE260;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	public BST(Integer[] integers) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BST tree = new BST(new Integer[] {3, 1, 2, 0, 5, 4, 6, 8, 7, 9});
		printTree(tree);
	}
	
	public static void printTree(BST tree) {
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nInorder(non recursive) (sorted): ");
		tree.nonRecInOrder();
		System.out.print("\nPostOrder: ");
		tree.postorder();
		System.out.print("\nPostorder(non recursive): ");
		tree.nonRecPostOrder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.print("\nPreorder(non recursive): ");
		tree.nonRecPreOrder();
		System.out.print("\nThe number of nodes is " + tree.getSize());
		System.out.println();
		
	}
    /**
     * Insert element o into the binary tree
     * Return true if the element is inserted successfully
     */
    public boolean insert(E e);

    /**
     * Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    public boolean delete(E e);

    /** Preorder traversal from the root */
    public void preorder();

    /** Inorder traversal from the root */
    public void inorder();

    /** Postorder traversal from the root */
    public void postorder();

    /** Get the number of nodes in the tree */
    public int getSize();

    /** Return true if the tree is empty */
    public boolean isEmpty();
}

abstract class AbstractTree<E> implements Tree<E> {
    @Override /** Preorder traversal from the root */
    public void preorder() {
    }

    @Override /** Inorder traversal from the root */
    public void inorder() {
    }

    @Override /** Postorder traversal from the root */
    public void postorder() {
    }

    @Override /** Return true if the tree is empty */
    public boolean isEmpty() {
        return getSize() == 0;
    }
}

class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    /** Create a default binary tree */
    public BST() {
    }

    /** Create a binary tree from an array of objects */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override /**
               * Insert element o into the binary tree
               * Return true if the element is inserted successfully
               */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; // Element inserted successfully
    }

    @Override /**
               * Delete an element from the binary tree.
               * Return true if the element is deleted successfully
               * Return false if the element is not in the tree
               */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed at by current
        }
        if (current == null)
            return false; // Element is not in the tree
        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;
            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true; // Element deleted successfully
    }

    @Override /** Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
        if (root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list; // Return an array list of nodes
    }

    @Override /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /** Returns the root of the tree */
    public TreeNode<E> getRoot() {
        return root;
    }
    
    public void breadthFirstTraversal() {
    	Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
    	queue.add(root);
    	System.out.println("Print Bredth First Treversal of the BST: ");
    	while(queue.size() >0) {
    		TreeNode<E> current = queue.remove();
    		System.out.print(current.element + ", ");
    		
    		if(current.left != null) queue.add(current.left);
    		if(current.right != null) queue.add(current.right);
    	}
    	
    public int height() {
    	return heightHelper(root);
    }
    
    private int heightHelper(TreeNode<E> node) {
    	if(node == null) return 0;
    	
    	return Math.max(heightHelper(node.left), heightHelper(node.right)) +1;
    }
    
    public int getNumberOfLeaves() {
    	return getNumLeavesHelper(root);
    }
    
    private int getNumLeavesHelper(TreeNode<E> node) {
    	if(node == null) return 0;
    	if(node.left == null && node.right == null)
    		return 1;
    	return getNumLeavesHelper(node.left) + getNumLeavesHelper(node.right);
    }
    
    public int getNumberofNonLeaves() {
    	return size - getNumberofLeaves();
    }
    
    public boolean isFullBST() {
    	int height = height();
    	int numLeaves = getNumberOfLeaves();
    	return numLeaves == Math.pow(2, height - 1);
    }
    
    public BST<E> clone(){
    	BST<E> newBST = new BST<E>();
    	cloneHelper(root, newBST);
    	return newBST;
    }
    
    private void cloneHelper(TreeNode<E> node, BST<E> newBST) {
    	if(node == null) return;
    	newBST.insert(node.element);
    	cloneHelper(node.left, newBST);
    	cloneHelper(node.right, newBST);
    }
    
    private boolean equalsHelper(TreeNode<E> node, TreeNode<E> newNode) {
    	if(node == null) return false;
    	else if(node == null) return false;
    	else if(newNode == null) return false;
    	
    	if(node.element.equals(newNode.element)) {
    		return equalsHelper(node.left, newNode.left) && equalsHelper(node.right, newNode.right);
    	} else
    		return false;
    }
    
    public void nonRecPreOrder() {
    	if(root == null) return;
    	Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
    	stack.push(root);
    	while(stack.size() >0) {
    		TreeNode<E> node = stack.pop();
    		System.out.print(node.element + " ");
    		if(node.right != null) stack.push(node.right);
    		if(node.left != null) stack.push(node.left);
    	}
    }
    
    public void nonRecInOrder() {
    	if(root == null) return;
    	Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
    	TreNode<E> node = root;
    	while(node != null || stack.size() > 0) {
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    	}
    	
    	node = stack.pop();
    	System.out.print(node.element + " ");
    	node = node.right;
    }
    
    }
    
    public void NonRecPostOrder() {
    	if(root == null) return;
    	Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
    	stack.push(root);
    	TreeNode<E> prev = null;
    	while(stack.size() > 0) {
    		TreeNode<E> current = stack.peek();
    		
    		if(prev == null||prev.left == current || prev.right == current) {
    			if(current.left != null)
    				stack.push(current.left);
    			else if(current.right != null)
    				stack.push(current.right);
    			else {
    				stack.pop();
    				System.out.print(current.element + " ");
    			}
    		}
    		
    		else if (current.left == prev) {
    			if(current.right != null)
    				stack.push(current.right);
    			else {
    				stack.pop();
    				System.out.print(current.element + " ");
    			}
    		}
    		
    		else if (current.right == prev) {
    			stack.pop();
    			System.out.print(current.element + " ");
    		}
    		prev = current;
    		
    		
    	}
    }

}
