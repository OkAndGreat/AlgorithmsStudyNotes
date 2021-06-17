import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a=new int[]{2,3,6,7};
    }

}

class Solution {
    int[] vis;
    int target;
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target=target;
        Arrays.sort(candidates);
        vis=new int[candidates.length];
        List<Integer> temp = new ArrayList();
        for(int i=0;i<candidates.length;i++){
            temp.add(candidates[i]);
            dfs(i+1,temp,candidates[i],candidates);
            temp.clear();
        }
        return res;
    }

    void dfs(int idx,List<Integer> temp,int value,int[] candidates){
        if(value==target){
            res.add(new ArrayList(temp));
            return;
        }
        if(value>target) return;
        for(int i=idx;i<candidates.length;i++){
            if(i>0&&candidates[i-1]==candidates[i]&&vis[i-1]==0) continue;
            temp.add(candidates[i]);
            value+=candidates[i];
            dfs(i+1,temp,value,candidates);
            value-=candidates[i];
            temp.remove(temp.size()-1);
        }
    }
}



