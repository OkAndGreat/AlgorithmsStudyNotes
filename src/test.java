import java.util.*;

//[9]
//[1,9,9,9,9,9,9,9,9,9]
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode curL2 = l2;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(9);
        curL2 = curL2.next;
        curL2.next = new ListNode(1);


    }

}

class Solution {
    ListNode node;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = getNodeVal(l1) + getNodeVal(l2);
        node = new ListNode(val % 10);
        val /= 10;
        ListNode curNode = node;
        while (val != 0) {
            int num = val % 10;
            curNode.next = new ListNode(num);
            curNode = curNode.next;
            val /= 10;
        }
        return node;
    }

    int getNodeVal(ListNode node) {
        int res = 0;
        int a = 1;
        do {
            res += node.val * a;
            a *= 10;
            node = node.next;
        } while (node != null);
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



