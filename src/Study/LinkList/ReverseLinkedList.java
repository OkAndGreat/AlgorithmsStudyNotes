package Study.LinkList;

import java.util.Stack;

/**
 * 将链表反转
 * 方法一:将链表中的元素挨个取出放入栈中然后pop出最后一个元素就成了第一个元素
 * 方法二:创建一个头指针将链表中的元素挨个取出然后插入
 */
public class ReverseLinkedList {
    MyLinkedList myLinkedList;

    public ReverseLinkedList(MyLinkedList myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    public void reverseLinkedList1() {
        Stack<HeroNode> myLinkedLists = new Stack<>();
        HeroNode temp = myLinkedList.header.next;

        if (temp == null || temp.next == null) {
            System.out.println("该链表为空或仅有一个元素,无需反转");
            return;
        }

        while (temp.next != null) {
            myLinkedLists.push(temp);
            temp = temp.next;
        }

        myLinkedList.header.next = temp;
        while (myLinkedLists.empty() == false) {
            HeroNode pop = myLinkedLists.pop();
            temp.next = pop;
            temp = pop;
        }
        temp.next = null;
        myLinkedList.printList();
    }

    public void reverseLinkedList2() {
        HeroNode header = new HeroNode(null);
        HeroNode toReverseNode=null;
        if(myLinkedList.header.next==null)
        {
            System.out.println("该链表为空,无需反转");
            return;
        }
        HeroNode temp=myLinkedList.header.next;
        toReverseNode=temp.next;
        do{
            temp.next=header.next;
            header.next=temp;
            temp=toReverseNode;
            toReverseNode=toReverseNode.next;
        }while (toReverseNode!=null);
        temp.next=header.next;
        header.next=temp;
        myLinkedList.header.next=temp;
        myLinkedList.printList();
    }
}
