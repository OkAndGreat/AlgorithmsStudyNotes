import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a=new int[]{2,3,6,7};
        solution.combinationSum(a,7);
    }

}

class Solution {
    List<List<Integer>> res = new ArrayList();
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target=target;
        for(int i=0;i<candidates.length;i++)
            dfs(candidates,i,0,new ArrayList<Integer>());
        return res;
    }

    void dfs(int[] candidates,int idx,int value,List<Integer> temp){
        if(value==target){
            res.add(new ArrayList(temp));
            return;
        }
        if(value>target) return;
        for(int i=idx;i<candidates.length;i++){
            value+=candidates[i];
            temp.add(candidates[i]);
            dfs(candidates,i+1,value,temp);
            value-=candidates[i];
            temp.remove(temp.indexOf(candidates[i]));
        }
    }
}



