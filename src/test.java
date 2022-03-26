import java.util.*;

public class test {
    public static void main(String[] args) {
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] a = new int[][]{{3, 3}, {5,-1},{-2,4}};
        StringBuilder sb = new StringBuilder();
        System.out.println(new Solution().generateParenthesis(1));
    }



}

class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,0,new StringBuilder());
        return res;
    }

    void dfs(int left,int right,int leftNeed,StringBuilder sb){
        if(leftNeed > 0) return;
        if(left == 0 && right == 0) res.add(sb.toString());
        if(left > 0){
            sb.append("(");
            left--;
            leftNeed--;
            dfs(left,right,leftNeed,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > 0){
            sb.append(")");
            right--;
            leftNeed++;
            dfs(left,right,leftNeed,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}