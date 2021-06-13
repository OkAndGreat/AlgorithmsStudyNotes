import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"1"};
        solution.combine(4, 2);
    }

}

class Solution {
    List<List<Integer>> res = new ArrayList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        for (int i = 1; i <= n - k + 1; i++)
            fun(i, new ArrayList());
        return res;
    }

    void fun(int idx, List<Integer> temp) {
        temp.add(idx);
        dfs(idx + 1, temp);
    }

    void dfs(int idx, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = idx; i <= n; i++) {
            dfs(i + 1, temp);
            temp.add(i);
            dfs(i + 1, temp);
            temp.remove(temp.indexOf(i));
        }
    }
}



