/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 通过次数491,284提交次数687,408
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
   
###注意点：如果head为null直接返回否则后面从栈中拿数据会报错
###其实很多题都有类似的处理方式，在开始后面的步骤对数据判空

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//看到反转很容易想到栈
 //注意链表可能产生环
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        Stack<ListNode> stack=new Stack();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode temp=stack.pop();
        ListNode hea=temp;
        ListNode temp1;
        while(!stack.isEmpty()){
            temp1=stack.pop();
            temp1.next=null;
            temp.next=temp1;
            temp=temp1;
        }
        return hea;

    }
}
````

