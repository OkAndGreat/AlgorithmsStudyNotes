package Study.LinkList;

/**
 * 问题描述:
 * 据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，
 * 39个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，
 * 于是决定了一个自杀方式，41个人排成一个圆圈，
 * 由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止
 * 现求死亡顺序
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.createList(41);
        circleLinkedList.startGame(1,3);
    }
}

class CircleLinkedList {
    Boy first;
    Boy Last;

    public void createList(int num) {
        //创建环形链表
        for (int i = 1; i < num + 1; i++) {
            if (i == 1) {
                first = new Boy(i);
                Last = first;
            } else {
                Last.next = new Boy(i);
                Last = Last.next;
                Last.next = first;
            }
        }
        //展示环形链表
        Boy CurBoy = first;
        while (true) {
            System.out.println("当前小孩编号 -->" + CurBoy.no);
            CurBoy = CurBoy.next;
            //遍历完一圈,循环结束
            if (CurBoy == first) {
                break;
            }
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示计数几下
     */
    public void startGame(int startNo, int countNum) {
    //在开始前,将first和last移动 startNo -1 次
        for(int i=0;i<startNo-1;i++){
            first=first.next;
            Last=Last.next;
        }
        //每次被出圈的元素是first所指向的元素
        //将first指针指向它的下一个节点
        //将Last指针指向节点的next指向first所指向的节点就实现了元素出圈(因为出圈的元素不再被引用,会被Java GC回收)
        //因为判断到了最后一个元素的条件就是first指针和last指针指向了同一个元素
        while(first!=Last){
            //首先将first指针指向要出圈的节点
            for(int i=0;i<countNum-1;i++){
                first=first.next;
                Last=Last.next;
            }
            System.out.printf("%d号出圈\n",first.no);
            first=first.next;
            Last.next=first;
        }
        System.out.printf("%d号出圈\n",first.no);
    }
}

// 创建一个Boy类，表示一个节点
class Boy {
    public int no;// 编号
    public Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }
}
