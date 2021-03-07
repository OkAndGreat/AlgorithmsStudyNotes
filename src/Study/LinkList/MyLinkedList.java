package Study.LinkList;

public class MyLinkedList {
    HeroNode header = new HeroNode(null);
    //记录链表最后一个节点方便不按顺序添加时效率提高
    HeroNode LastNode = header;

    //在链表的最后添加数据
    public void add(HeroNode heroNode) {
        LastNode.next = heroNode;
        LastNode = heroNode;
    }

    //按照id大小添加数据
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = header;
        while (temp.next != null) {
            if (heroNode.id < temp.next.id) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            } else if (heroNode.id == temp.next.id) {
                System.out.println("不能加入相同id哦~~");
                break;
            }
            temp = temp.next;
        }
        //处理加入的节点是第一个或最后一个
        if (temp.next == null) {
            temp.next = heroNode;
        }

    }

    //打印链表
    public void printList() {
        HeroNode temp = header;
        if (header.next == null) {
            System.out.println("链表为空");
        } else {
            while (temp.next != null) {
                System.out.println(temp.next.toString());
                temp = temp.next;
            }
        }

    }
}

class HeroNode {
    public int id;
    public String name;
    public HeroNode next = null;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public HeroNode(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


