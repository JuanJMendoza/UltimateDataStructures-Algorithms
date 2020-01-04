package Trees;

public class Tree {
    ///////////////////
    /// Node Class ///
    ///////////////////
    /**
     * private node class with implementation details.
     */
    private class Node{
        // value is a reference to the int type value the node will hold.
        private int value;
        // leftChild is a reference to the left node child of this particular node.
        private Node leftChild;
        // rightChild is a reference to the right node child of this particular node.
        private Node rightChild;

        /**
         * This is a public Node constructor, allowing us to instantiate a Node object with a int value parameter.
         * @param value is the value this particular node will hold.
         */
        public Node(int value){
            this.value = value;
        }

        // overrode the toString method in the Node class so Node values would convey better in the debugger.
        @Override
        public String toString(){
            return "Node = " + this.value;
        }

    }
    // root is a reference to the starting node in the tree class.
    private Node root;

    /**
     * @param value is the value we are trying to insert into the Tree.
     */
    public void insert(int value){
        // if root is null then this means there are no nodes in out Tree object.
        if(root == null){
            // we can give the root the value we're trying to insert.
            root = new Node(value);
            // we immediately break out of the function so the rest of the function does not execute.
            return;
        }

        // getting here means there is an existing root in out Tree, so we reference to the root with a
        // variable with a more discerning name for us to navigate through the Tree.
        Node current = root;

        // Until we break out of the while loop manually from inside the loop after inserting.
        while(true){
            // if value is less then the current node's value we know we should go down the left subtree.
            if(value < current.value){
                // we check if the left subtree is empty, if so we know to insert a new node with value as its value
                if(current.leftChild == null){
                    // we insert a new node and make it the current node's left child w/ the input value as its value.
                    current.leftChild = new Node(value);
                    // we break out the loop.
                    break;
                }
                // if the left subtree wasn't empty then we traverse down the left subtree and make the current node
                // equal to the current node's left child.
                current = current.leftChild;
            }
            // otherwise, the value is larger then the current node's value.
            else if(value > current.value){
                // if the right subtree is empty, if so we know to insert a new node w/ the input value as its value.
                if(current.rightChild == null) {
                    // we insert a new node and make it the current node's right child w/ the input value as its value.
                    current.rightChild = new Node(value);
                    // we break out the loop.
                    break;
                }
                // if the right subtree wasn't empty then we traverse down the right subtree and make the current node
                // equal to the current node's left child.
                current = current.rightChild;
            }
        }
    }


    /**
     * @param value parameter is the value we're searching for in out Tree.
     * @return returns a boolean which will convey whether the value is found in the Tree or not.
     */
    public boolean find(int value){
        Node current = root;

        // until we've found the node with our corresponding value, or we traversed down to a null child,
        // we will continue to traverse down the tree.
        while (current != null){
            // if the value we're looking for is less than the current node's value, check if its left child is valid
            if(value < current.value){
                // if there is a left child we make current equal to current node's left child.
                current = current.leftChild;
            }
            // if the value we're looking for is greater than the current node's value, check if its right child is valid
            else if (value > current.value){
                // if there is a right child we make current equal to current node's right child.
                current = current.rightChild;
            }
            else { // if we get to this case, then we've found the node in our tree with the value we were looking for
                // and we return true.
                return true;
            }
        }
        // we exited the loop b/c we traversed past a leaf to a null child, or the root was null, and return false.
        return false;
    }


    /**
     * Recursive method to traverse tree in preOrder traversal(root, left, right).
     */
    public void traversePreOrder(){
        // call to private recursive method.
        traversePreOrder(root);
    }


    /**
     * Recursive method to traverse tree in preOrder traversal(root, left, right).
     * @param root is the root node of the tree.
     */
    private void traversePreOrder(Node root) {
        // Base case: we check to see if we're at a leaf, hence if we go down a leaf's 'child' we will get a null.
        if (root == null) {
            return;
        }
        // print the current node's value on the console.
        System.out.println(root);
        // this function calls itself on its left child until we get to the base case.
        traversePreOrder(root.leftChild);
        // this function calls itself on its right child until we get to the base case.
        traversePreOrder(root.rightChild);
    }


    /**
     * Recursive method to traverse tree in inOrder traversal(left, root, right).
     */
    public void traverseInOrder(){
        // call to private recursive method.
        traverseInOrder(root);
    }


    /**
     * Recursive method to traverse tree in inOrder traversal(left, root, right).
     * @param root is the root node of the tree.
     */
    private void traverseInOrder(Node root){
        // Base case: we check to see if we're at a leaf, hence if we go down a leaf's 'child' we will get a null.
        if (root == null){
            return;
        }

        // this function calls itself on its left child until we get to the base case.
        traverseInOrder(root.leftChild);
        // print the current node's value on the console.
        System.out.println(root);
        // this function calls itself on its right child until we get to the base case.
        traverseInOrder(root.rightChild);
    }


    /**
     * Recursive method to traverse tree in postOrder traversal(left, right, root).
     */
    public void traversePostOrder(){
        // call to private recursive method.
        traversePostOrder(root);
    }


    /**
     * Recursive method to traverse tree in postOrder traversal(left, right, root).
     * @param root is the root node of the tree.
     */
    private void traversePostOrder(Node root){
        // Base case: we check to see if we're at a leaf, hence if we go down a leaf's 'child' we will get a null.
        if (root == null){
            return;
        }

        // this function calls itself on its left child until we get to the base case.
        traversePostOrder(root.leftChild);
        // this function calls itself on its right child until we get to the base case.
        traversePostOrder(root.rightChild);
        // print the current node's value on the console.
        System.out.println(root);
    }


    public int height(){
        // call to private recursive method.
        return height(root);
    }


    private int height(Node root){
        // Base case 1: if root is null return -1.
        if (root == null) {
            return -1;
        }
        // Base case 2: if both children of current node are null then we are on a leaf, so we return 0.
        if (root.leftChild == null && root.rightChild == null){
            return 0;
        }

        // Recursively call height on both left child and right child. When we get a leaf node of left child, we return
        // 0 as per base case 2. Then we recursively call height on right child until we get to base case 2. We do this
        // for both side and once finished for a sub tree, we compare and return the max of either on and add 1. We then
        // continue until we propogate back to the root of the tree and do it for the right subtree, and continue doing
        // so until we finally come back to the root of the tree and add 1 to the max of either subtree height, and
        // return that sum. Formula for height of a tree is 1 + max(height(LeftChild), height(RightChile));
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }


    public int minValue(){
        // we make a call to the recursive function, minValue.
        return minValue(root);
    }


    /**
     * O(n) because we have to check each node in the tree, and there are n nodes.
     * @param root is the current node we're on.
     * @return the min value between the roots left and right subtrees and itself.
     */
    private int minValue(Node root) {
        // if the this current root node is a leaf we return its value.
        if (isLeaf(root)){
            return root.value;
        }

        var left = minValue(root.leftChild);
        var right = minValue(root.rightChild);
        // otherwise we return the minimum of both subtrees of the tree's root node and the minimum of those two we use
        // to compare the smallest between that value and the tree's root value (postOrder - left, right, root), and
        // return the min of those values.
        return Math.min(Math.min(left, right), root.value);
    }


    /**
     *  O(log n) because we get rid of half the tree's node each pass we make in the loop since we're only trying to
     *  get to the left most node of the binary search tree.
     * @return returns the smallest value (left most node) of the tree.
     */
    public int minValueOfBST(){
        // throws an exception if root is null.
        if (root == null) {
            throw new IllegalStateException();
        }
        // current is a traversing node
        Node current = root;
        // last will be the last node current is before taking a null value and having us exit the loop.
        Node last = current;

        // while current is not null we will continue iterating through the left subtrees
        while (current != null){
            // last takes the current value of current before current takes the value of its left subtree node
            last = current;
            // current takes the value of its left subtree node
            current = current.leftChild;
        }
        // returns the value if last, the left most node's value.
        return last.value;
    }


    /**
     * @param node is the input node we're checking to see if it is a leaf node.
     * @return returns a boolean value conveying if the node is a leaf or not.
     */
    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }


    public boolean equals(Tree other){
        // check if other is null.
        if (other == null){
            return false;
        }
        // returns if both this tree and the other are equal.
        return equals(root, other.root);
    }


    private boolean equals(Node first, Node second){
        // Check if both nodes are leaves
        if (first == null && second == null){
            return true;
        }

        // Check if both nodes are not null
        if (first != null && second != null){
            // if they both aren't null, then check if their roots, left subtrees, and right subtrees match.
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        // Otherwise, we return false.
        return false;
    }
}