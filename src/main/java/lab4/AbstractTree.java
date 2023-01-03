package lab4;

public abstract class AbstractTree {
    protected int count = 0;

    //查询节点
    public abstract Node find(int key);

    //插入节点
    public abstract boolean insert(int key);

    //删除节点
    public abstract boolean delete(int key);

    //中序遍历
    public abstract void inOrder(Node root);

    //节点个数
    public int getCount(){
        return this.count;
    }
}
