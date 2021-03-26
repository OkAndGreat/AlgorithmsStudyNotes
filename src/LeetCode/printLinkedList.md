/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
   
关键！！！！！！！！！！！  
看到类似反转，倒转等倒着来的词要想到stack  
因为stack有先进后出的特性！
```
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
```
//这个是最直接显然的想法  
//执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户  
//内存消耗： 38.8 MB , 在所有 Java 提交中击败了 91.92% 的用户
```
class Solution {
public int[] reversePrint(ListNode head) {
int count = 0;
ListNode temp = head;
while (temp != null) {
count++;
temp = temp.next;
}

        int[] output = new int[count];
        temp = head;
        while (temp != null) {
            output[--count] = temp.val;
            temp = temp.next;
        }

        return output;
    }
}
```