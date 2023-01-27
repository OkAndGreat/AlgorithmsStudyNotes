import java.util.*;

public class test {
    public static void main(String[] args) {
        //System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
class Solution {
    List<Integer> res;
    HashMap<TreeNode,TreeNode> hashMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    void findParents(TreeNode node){
        if(node == null) return;
        if(node.left != null) hashMap.
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