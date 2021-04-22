import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
    }
}

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result=new ArrayList();
        List<Integer> toAddList=new ArrayList();
        if(root==null) return result;
        recur(root,target,0,toAddList);
        return result;
    }
    void recur(TreeNode root, int target,int num,List<Integer> toAddList){
        if(root.val+num==target){
            result.add(toAddList);
        }else if(root.val+num>target){
            return;
        }else{
            if(root.left!=null) {
                toAddList.add(root.left.val);
                recur(root.left,target,num,toAddList);
            }
            if(root.right!=null) {
                toAddList.add(root.right.val);
                recur(root.right,target,num,toAddList);
            }
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
