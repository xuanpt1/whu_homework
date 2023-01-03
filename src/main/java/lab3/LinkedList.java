package lab3;

public class LinkedList<E> implements List<E> {
    static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E data , Node<E> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = rare;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = front;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    private int size = 0;//大小
    private Node<E> rare;//尾结点
    private Node<E> front;//头节点

    LinkedList(){}

    public E GetHead(){return front.data;}

    @Override
    public boolean ListEmpty() {
        return !(size > 0);
    }

    @Override
    public int ListLength() {
        return size;
    }

    @Override
    public void ListInsert(int i, E e) {
        if(i == size){
            linkFirst(e);
        }else {
            Node<E> pred = node(i).prev;
            Node<E> newNode = new Node<>(pred,e,node(i));
            node(i).prev = newNode;
            if (pred == null){
                rare = newNode;
            }else {
                pred.next = newNode;
            }
            size++;
        }
    }

    @Override
    public E GetElem(int i) {
        if (i >= 0 && i < size) return node(i).data;
        else return null;
    }

    @Override
    public E ListDelete(int i) {
        final E elem = node(i).data;
        final Node<E> next = node(i).next;
        final Node<E> prev = node(i).prev;

        if (prev == null) {
            rare = next;
        } else {
            prev.next = next;
            node(i).prev = null;
        }

        if (next == null) {
            front = prev;
        } else {
            next.prev = prev;
            node(i).next = null;
        }

        node(i).data = null;
        size--;
        return elem;
    }

    @Override
    public void ClearList() {
        for (Node<E> x = rare; x != null; ) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        rare = front = null;
        size = 0;
    }

    @Override
    public int LocateElem(E e) {
        int index = 0;
        if (e == null){
            for(Node<E> x = rare; x != null; x = x.next){
                if(x.data == null) return index;
                index ++;
            }
        }else {
            for (Node<E> x = rare; x != null ; x = x.next){
                if (e.equals(x.data)) return index;
                index ++;
            }
        }
        return -1;
    }

    @Override
    public void ListUpdate(int i, E e) {
        node(i).data = e;
    }

    void linkFirst(E e) {
        final Node<E> f = rare;
        final Node<E> newNode = new Node<>(null, e, f);
        rare = newNode;
        if (f == null)
            front = newNode;
        else
            f.prev = newNode;
        size++;
    }
}




