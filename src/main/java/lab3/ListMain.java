package lab3;

public class ListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        System.out.println(list.ListEmpty());

        list.ListInsert(0,123);
        list.ListInsert(1,133);
        list.ListInsert(2,145);

        System.out.println(list.ListLength());
        System.out.println(list.GetHead());
        System.out.println(list.GetElem(1));
        System.out.println(list.LocateElem(145));
        System.out.println(list.LocateElem(114));
        list.ListUpdate(2,321);
        System.out.println(list.GetElem(2));
        System.out.println(list.ListDelete(1));
        list.ClearList();
        System.out.println(list.ListEmpty());

    }
}
