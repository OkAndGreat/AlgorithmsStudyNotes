package Study.LinkedList;
/**
 * 将俩个有序的链表相加成为一个有序的链表
 * 第一种方法:将其中一个链表的数据挨个取出并复制然后通过另一个链表的addByOrder方法加入
 * 第二种方法:将其中一个链表的数据挨个取出不复制改变它的引用加入到另一个链表中
 */
public class AddLinkedList {
    public void addLinkedListByOrder(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        HeroNode temp = myLinkedList2.header;
        while (temp.next != null) {
            HeroNode toAddNode = new HeroNode(temp.next.id, temp.next.name);
            myLinkedList1.addByOrder(toAddNode);
            temp = temp.next;
        }
        myLinkedList1.printList();
    }

    public void addLinkedListById(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        HeroNode temp=null;
        HeroNode toAddNode=myLinkedList2.header.next;
        if(toAddNode==null){
            System.out.println("要加入的链表没有数据!");
            return;
        }
        //temp节点保存当前要加入节点的下一个节点
        //如果链表2只有一个数据的话直接加入到链表一中
        if (myLinkedList2.header.next.next != null) {
            temp = myLinkedList2.header.next.next;
        } else {
            myLinkedList1.addByOrder(myLinkedList2.header.next);
        }
        //循环结束后表明要加入的链表已经没有数据
        //这种方法相对上一种方法可以不new新数据
        while(toAddNode!=null){
            myLinkedList1.addByOrder(toAddNode);
            toAddNode=temp;
            if (temp!=null)
                temp=temp.next;
        }
        myLinkedList1.printList();
    }
}
