package Study.LinkList;

public class LinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addByOrder(new HeroNode(6, "松江"));
        linkedList1.addByOrder(new HeroNode(3, "鲁智深"));
        linkedList1.addByOrder(new HeroNode(4, "奥特曼"));
        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addByOrder(new HeroNode(2, "松江"));
        linkedList2.addByOrder(new HeroNode(5, "鲁智深"));
        linkedList2.addByOrder(new HeroNode(9, "big怪兽"));
        AddLinkedList addLinkedList = new AddLinkedList();
        //addLinkedList.addLinkedListById(linkedList1,linkedList2);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList(linkedList2);
        //reverseLinkedList.reverseLinkedList1();
        //reverseLinkedList.reverseLinkedList2();

    }
}
