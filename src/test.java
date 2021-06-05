import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2};
        System.out.println(Arrays.deepToString(solution.permute(nums).toArray()));
    }


    static class Solution {
        List<List<Integer>> res;
        List<Integer> temp;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList();
            temp = new ArrayList();
            dfs(0, temp, nums);
            return res;
        }

        void dfs(int i, List<Integer> temp, int[] nums) {
            if (i == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int j = 0; j < nums.length; j++)
                if (!temp.contains(nums[j])) {
                    temp.add(nums[j]);
                    dfs(i + 1, temp, nums);
                    temp.remove(temp.indexOf(nums[j]));
                }
        }
    }
}