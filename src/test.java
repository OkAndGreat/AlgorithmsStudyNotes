import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1, 1};
        System.out.println(Arrays.deepToString(solution.permuteUnique(nums).toArray()));
    }

}

class Solution {
    List<List<Integer>> res;
    //0说明还未添加 1则相反
    int[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList();
        vis=new int[nums.length];
        Arrays.sort(nums);
        dfs(0,nums,new ArrayList());
        return res;
    }

    void dfs(int i,int[] nums,List<Integer> temp){
        if(i==nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int j=0;j<nums.length;j++){
            //考虑重复序列
            if(vis[j]==1||(j>0&&nums[j]==nums[j-1]&&vis[j-1]==0)) continue;
            temp.add(nums[j]);
            vis[j]=1;
            dfs(i+1,nums,temp);
            //体现回溯
            vis[j]=0;
            temp.remove(i);
            //temp.remove(temp.indexOf(nums[j]));
            // 是错误的
            //因为存在多个相同元素，可能得到错误的下标
        }
    }
}




