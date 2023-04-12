import java.util.List;
import java.util.ArrayList;

/*
 * Purpose:
 *     To self implement a binary tree, traverse in-order, balance the tree, then traverse pre-order
 * 
 * Authors:
 *     Peyton Cusick
 *     Bryce LeCates
 * 
 * Input:
 *     File: list of numbers
 * Output:
 *     Print the original array, in-order traverse, and pre-order traverse
 * 
 * How to Use:
 *     1) Make a file of numbers seperated by commas
 *
 * Expected Data:
 *     File of numbers seperated by commas
 * 
 * Expected Exceptions:
 *     IOException
 * 
 * Major Classes:
 *     BT: (Binary Tree) - implements a binary tree using "double" linked lists
 *     Node: implements the node of the binary tree
 */

public class BT<E extends Comparable<E>> {
    private Node<E> root;

    public BT() {
        this.root = null;
    }

    public BT(Node<E> root) {
        this.root = root;
    }

    public BT(E data, BT<E> leftTree, BT<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }
    
    /*
    *   returns: BT<E> - returns the left side of the binary tree
    */
    public BT<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BT<>(root.left);
        } else {
            return null;
        }
    }
    
    /*
    *   returns: BT<E> - returns the right side of the binary tree
    */
    public BT<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BT<>(root.right);
        } else {
            return null;
        }
    }
    
    /*
    *   returns: boolean - returns if the node is a leaf (w/o any children)
    */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /*
    *   returns: List<E> - returns a array showing how the binary tree was traversed pre-order
    */
    public List<E> preOrder() {
        List<E> sb = new ArrayList<E>();
        preOrder(root, sb);
        return sb;
    }
    
    /*
    *   -input: Node<E> - current node, List<E> - array of traverse
    *   -traverses the root node(adds to List<E>), then traverses to the left, and then to the right
    *   -recursive
    */
    public void preOrder(Node<E> node, List<E> sb) {
        if (node == null) {
            return;
        }
        sb.add(node.data);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    /*
    *   returns: ArrayList<E> - returns a array showing how the binary tree was traversed pre-order
    */
    public ArrayList<E> inOrder() {
        ArrayList<E> sb = new ArrayList<E>();
        inOrder(root, sb);
        return sb;
    }
    
    /*
    *   -input: Node<E> - current node, ArrayList<E> - array of traverse
    *   -traverses to the left, traverses to the root node(adds to ArrayList<E>), and then to the right
    *   -recursive
    */
    public void inOrder(Node<E> node, ArrayList<E> sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.add(node.data);
        inOrder(node.right, sb);
    }
    
    /*
    *   returns: String - calls the recursive toString to build the String representation of the binary tree
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }
    
    /*
    *   -input: Node<E> - current node, int - tracks the depth of the tree, StringBuilder - String of binary tree
    *   -traverses the tree pre-order, indentation is how deep the node is, null means there is no child on that side
    *   -recursive
    */
    public void toString(Node<E> node, int depth, StringBuilder sb) {
        for (int i=1; i<depth; i++) {
            sb.append(" ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth+1, sb);
            toString(node.right, depth+1, sb);
        }
    }
    
    /*
    *   returns: Node<E> - returns the root of the binary tree
    */
    public Node<E> getRoot() {
        return this.root;
    }
    
    /*
    *   sets the root node
    */
    public void setRoot(E root) {
        this.root = new Node<E>(root);
    }

    /*
    *   -input: E - item to add to binary tree
    *   -sets the root node to the result of the recursive add()
    */
    public void add(Node<E> item) {
        root = add(root, item);
    }
    
    /*
    *   -input: E - item to add to binary tree
    *   -sets the root node to the result of the recursive add()
    */
    public void add(E item) {
        root = add(root, item);
    }

    /*
    *   -input: Node<E> - current node, E - data to compare
    *   -returns: Node<E> - node added
    *   -recursively compares the item to be added to each node and until the bottom of the tree is reached
    */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    
    /*
    *   -input: Node<E> - current node, Node<E> - node to add
    *   -returns: Node<E> - node added
    *   -recursively compares the item to be added to each node and until the bottom of the tree is reached
    */
    private Node<E> add(Node<E> localRoot, Node<E> item) {
        if (localRoot == null) {
            return item;
        } else if (item.data.compareTo(localRoot.data) == 0) {
            return localRoot;
        } else if (item.data.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    
    /*
    *   -input: ArrayList<E> - array of traversal
    *   -sets the root node to the result of the recursive balancedTree()
    */
    public void balancedTree(ArrayList<E> arr) {
        root = balancedTree(arr, 0, arr.size()-1);
    }
    
    /*
    *   -input: ArrayList<E> - traversal array, int - left limit of subarray, int - right limit of subarray
    *   -returns: Node<E> - root node
    *   -recursively makes the middle of the subarray the root node, the splits the subarray in half
    */
    public Node<E> balancedTree(ArrayList<E> arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        Node<E> node = new Node<E>(arr.get(mid));
        add(node);
        node.left = balancedTree(arr, left, mid-1);
        node.right = balancedTree(arr, mid+1, right);
        return node;
    }

    public class Node<E> {
        private E data;
        private Node<E> right;
        private Node<E> left;

        public Node(E data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
        
        //returns node data
        public E getData() {
            return this.data;
        }
        
        //returns left child of node
        public Node<E> getLeft() {
            return this.left;
        }
    
        //returns right child of node
        public Node<E> getRight() {
            return this.right;
        }
        
        //prints node data
        public String toString() {
            return data.toString();
        }
        
        //returns if node is a leaf (w/o children)
        public boolean isLeaf() {
            return (right == null && left == null);
        }
    } //end of Node class
} //end of BT class
