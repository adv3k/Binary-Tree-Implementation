import java.util.List;
import java.util.ArrayList;


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

    public BT<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BT<>(root.left);
        } else {
            return null;
        }
    }

    public BT<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BT<>(root.right);
        } else {
            return null;
        }
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public String preOrder() {
        List<String> sb = new ArrayList<String>();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(Node<E> node, List<String> sb) {
        if (node == null) {
            return;
        }
        sb.add(node.data+"");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public List<String> inOrder() {
        List<String> sb = new ArrayList<String>();
        inOrder(root, sb);
        return sb;
    }
    public void inOrder(Node<E> node, List<String> sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.add(node.data + "");
        inOrder(node.right, sb);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }

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

    public Node<E> getRoot() {
        return this.root;
    }

    public void setRoot(E root) {
        this.root = new Node<E>(root);
    }

    public void add(E item) {
        root = add(root, item);
    }
    //recursive add method from textbook
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

    public Node<E> balancedTree(List<E> arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        root.data = arr.get(mid);
        root.left = balancedTree(arr, left, mid-1);
        root.right = balancedTree(arr, mid+1, right);
        return root;
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

        public E getData() {
            return this.data;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }
        
        public String toString() {
            return data.toString();
        }

        public boolean isLeaf() {
            return (right == null && left == null);
        }
    } //end of Node class
} //end of BT class