/**

* 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
*
* 例如输入：
*
* 4
* / \
* 2 7
* / \ / \
* 1 3 6 9
* 镜像输出：
*
* 4
* / \
* 7 2
* / \ / \
* 9 6 3 1
*
*
*
* 示例 1：
*
* 输入：root = [4,2,7,1,3,6,9]
* 输出：[4,7,2,9,6,3,1]
*
*
* 限制：
*
* 0 <= 节点个数 <= 1000
*
* 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
*
* 通过次数118,721提交次数150,634
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
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
//在开始写具体代码前要考虑数据是否要去判空！错了很多次了
class Solution {
    TreeNode temp;

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (root.left != null)
            mirrorTree(root.left);
        if (root.right != null)
            mirrorTree(root.right);
        return root;
    }
}

//辅助栈做法
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
````

