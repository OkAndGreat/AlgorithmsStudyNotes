/**
 *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *  3
 * / \
 * 4  5
 *  / \
 * 1  2
 * 给定的树 B：
 *
 * 4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 通过次数85,121提交次数184,938
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
   
````java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //一定记得首先判断值给的是否为空！！！
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    //对于A和B的取值有四种情况：
    //1.A==nullB==null 应该返回true
    //2.A==nullB！==null 返回false
    //3.A！=nullB==null  返回true
    //4.A和B都不为null 此时若A和B的值不相同则返回false，相同则返回recur(A.left, B.left) && recur(A.right, B.right)
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
````
