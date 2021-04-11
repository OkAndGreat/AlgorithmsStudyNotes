import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums={3,2,1};
        //solution.getLeastNumbers(nums,2);

        LinkedList<Integer> stack=new LinkedList();
    }
}



// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    Node pre=null;
    public Node treeToDoublyList(Node root) {
        threadedNodes(root);
        return root;
    }

    void threadedNodes(Node root){
        Node node = root;
        if (node == null) return;
        threadedNodes(node.left);
        if (node.left == null) node.left=pre;
        if (pre != null && pre.right == null) pre.right=node;
        pre = node;
        threadedNodes(node.right);
    }
}