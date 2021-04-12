import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        System.out.println(Arrays.deepToString(solution.levelOrder(root).toArray()));
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<TreeNode,Integer> hash = new HashMap();
        if (root == null) return result;
        hash.put(root, 0);
        LinkedList<TreeNode> nodes = new LinkedList();
        nodes.addFirst(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollLast();
            if (result.size() < hash.get(node) + 1) result.add(new ArrayList<Integer>());
            result.get(hash.get(node)).add(node.val);
            //根据当前节点的层数去加入下一个节点
            TreeNode toAddNode;
            if (node.left != null) {
                toAddNode = node.left;
                hash.put(toAddNode, hash.get(node) + 1);
                nodes.addFirst(toAddNode);
            }
            if (node.right != null) {
                toAddNode = node.right;
                hash.put(toAddNode, hash.get(node) + 1);
                nodes.addFirst(toAddNode);
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}