/**

* 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
*
* 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
*
*
* 示例：
*
* 给定一个链表: 1->2->3->4->5, 和 k = 2.
*
* 返回链表 4->5.
* 通过次数149,076提交次数189,497
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  */

````java
//我的第一种解法

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (k != 1) {
            stack.pop();
            k--;
        }
        return stack.pop();
    }
}

//我的第二种解法
//这种方法速度更快，内存占用也更小
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int i = cnt - k;
        temp = head;
        while (i > 0) {
            temp = temp.next;
            i--;
        }
        return temp;
    }
}

//大佬解法
//双指针法，可以不用记录链表的长度
class Solution {
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode former = head, latter = head;
    for(int i = 0; i < k; i++)
      former = former.next;
    while(former != null) {
      former = former.next;
      latter = latter.next;
    }
    return latter;
  }
}

````

