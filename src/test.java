import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a=new int[]{2,3,6,7};
    }

}

class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(null);
        dfs(nums);
        return res;
    }

    void dfs(int[] nums){
        List<Integer> temp = new ArrayList();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(temp,nums,i);
            temp.remove(temp.size()-1);
        }
    }

    void dfs(List<Integer> temp,int[] nums,int idx){
        res.add(new ArrayList(temp));
        if(idx==nums.length) return;
        for(int i=idx;i<nums.length;i++){
            dfs(temp,nums,i+1);
            temp.add(nums[i]);
            dfs(temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}



