/**
*从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

*
*
*
* 例如:
* 给定二叉树:[3,9,20,null,null,15,7],
*
*     3
* / \
* 9 20
*     /  \
* 15 7
* 返回：
*
* [3,9,20,15,7]
*
*
* 提示：
*
* 节点总数 <= 1000
* 通过次数86,154提交次数133,074
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  */

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//这个算是层序遍历？
//我的思路 利用俩个栈 一个栈放一层的数据 另一个栈拿到那一层的数据然后再放下一层的数据到栈中
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> stack1 = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                result.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            a[i] = result.get(i);
        return a;
    }
}

//大佬的解法,时间比我写的快了很多，空间复杂度和我的差不多
//题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
//BFS 通常借助 队列 的先入先出特性来实现。

//哭了 突然发现我之前在第一次就是想用这种做法来做的。。。结果用的俩个栈去做了
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
````

