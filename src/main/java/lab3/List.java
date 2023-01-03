package lab3;

public interface List<E> {
    boolean ListEmpty();//若为空表返回true，否则false
    int ListLength();//返回数据元素个数
    E GetElem(int i);//返回第i个元素的值
    int LocateElem(E e);//返回表中e的次序，不存在则返回-1
    void ListInsert(int i ,E e);//在i位置插入元素e
    E ListDelete(int i);//删除i位置元素并返回该元素
    void ListUpdate(int i,E e);//更新i位置元素
    void ClearList();//清空列表


}
