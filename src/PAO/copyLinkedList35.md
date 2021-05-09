/**
*请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还

* 有一个 random 指针指向链表中的任意节点或者 null。
*

*/

````java
/**
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//关键点：使用HashMap存储原节点与新节点间的对应关系
class Solution {
    public Node copyRandomList(Node head) {
        //边界条件判断
        if (head == null)
            return null;
        //map存放已经创建的节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //遍历链表的所有节点，创建一个和链表节点value值一样的
        //新节点，这里的新节点的next和random都是空
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            //然后对新节点的next和random进行赋值
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

//递归解法，和上面的解法思路类似
class Solution {
    public Node copyRandomList(Node head) {
        //map存储已经创建的节点
        HashMap<Node, Node> map = new HashMap<>();
        return copyListHelper(head, map);
    }

    public Node copyListHelper(Node head, HashMap<Node, Node> map) {
        if (head == null)
            return null;
        //如果节点创建了，直接从map中取
        if (map.containsKey(head))
            return map.get(head);
        //如果节点没有创建，就创建一个，然后使用递归的方式在创建他的
        //next节点和random节点
        Node res = new Node(head.val);
        map.put(head, res);
        res.next = copyListHelper(head.next, map);
        res.random = copyListHelper(head.random, map);
        return res;
    }
}
````