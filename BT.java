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
