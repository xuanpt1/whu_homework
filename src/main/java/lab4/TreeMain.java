package lab4;

public class TreeMain {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(30);
        tree.insert(70);
        tree.insert(50);
        tree.insert(60);
        tree.insert(90);
        tree.insert(100);

        Node node = tree.find(30);

        tree.inOrder(tree.root);
        System.out.println(tree.getCount());
    }
}
