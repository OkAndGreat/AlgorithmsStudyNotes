/**
*请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

*
* 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
*
* 1
* \
* 2 2
* / \ / \
* 3 4 4 3
* 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
*
* 1
* / \
* 2 2
* \ \
* 3 3
*
*
*
* 示例 1：
*
* 输入：root = [1,2,2,3,4,4,3]
* 输出：true
* 示例 2：
*
* 输入：root = [1,2,2,null,3,null,3]
* 输出：false
*
*
* 限制：
*
* 0 <= 节点个数 <= 1000
*
* 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
*
* 通过次数90,643提交次数156,226
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        //首先判断头节点
        if ((root.left == null && root.right != null || root.right == null && root.left != null)) return false;
        return recur(root.left, root.right) && (root.right.val == root.left.val);
    }

    //给出俩颗树的头节点，返回这俩颗树是否对称
    boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (((left.left != null && right.right != null && left.left.val == right.right.val) || left.left == null && right.right == null) && ((left.right != null && right.left != null && left.right.val == right.left.val) || left.right == null && right.left == null)) {
            return recur(left.left, right.right) && recur(left.right, right.left);
        } else {
            return false;
        }
    }
}

//大佬解法
class Solution {
  public boolean isSymmetric(TreeNode root) {
    return root == null ? true : recur(root.left, root.right);
  }
  //传入要比较的是否对称的节点，我的方法是传入俩颗树的头节点，返回这俩颗树是否对称
  boolean recur(TreeNode L, TreeNode R) {
    if(L == null && R == null) return true;
    if(L == null || R == null || L.val != R.val) return false;
    return recur(L.left, R.right) && recur(L.right, R.left);
  }
}
````

