package lab4;

public class Tree extends AbstractTree{

    //根节点
    public Node root;

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null){
            if (current.data > key){
                current = current.leftChild;
            }else if (current.data < key){
                current = current.rightChild;
            }else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int key) {
        count ++;

        Node newNode = new Node(key);

        if (root == null){
            root = newNode;
            return true;
        }
        Node current = root;
        Node parent = null;

        while (current != null){
            parent = current;
            if (current.data > key){
                current = current.leftChild;
                if (current == null){
                    parent.leftChild = newNode;
                    return true;
                }
            }else {
                current = current.rightChild;
                if (current == null){
                    parent.rightChild = newNode;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        System.out.println(root.data + " ");
        inOrder(root.rightChild);
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftNode = false;

        //定位data为key的节点位置
        while (current.data != key){
            parent = current;
            if (current.data > key){
                isLeftNode = true;
                current = current.leftChild;
            }else {
                isLeftNode = false;
                current = current.rightChild;
            }

            if (current == null){
                return false;
            }
        }

        //1、 若此节点为叶子节点
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            }else if (isLeftNode){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
            return true;
        }

        //2、 若此节点有一个子节点
        if (current.leftChild == null){
            if(root == current){
                root = current.rightChild;
            }else if (isLeftNode){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.rightChild == null) {
            if (root == current){
                root = current.leftChild;
            }else if(isLeftNode) {
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
            return true;
        }

        //3、 又两个子节点
        //获取删除节点的后继结点
        Node successor = getSuccessor(current);
        if (root == current) {
            root = successor;
        } else if (isLeftNode) {
            parent.leftChild = successor;
            return true;
        } else {
            parent.rightChild = successor;
            return true;
        }

        return false;
    }

    private Node getSuccessor(Node delNode) {
        //获取后继节点
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
            successor.leftChild = delNode.leftChild;
        }
        return successor;
    }
}
