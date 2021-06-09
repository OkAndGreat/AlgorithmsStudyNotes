import java.util.*;

public class test {
    StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(4,9));
    }

}

class Solution {
    String res;
    int cnt=0;
    int k;
    int[] vis;
    StringBuilder sb=new StringBuilder();
    public String getPermutation(int n, int k) {
        this.k=k;
        vis=new int[n];
        for(int i=1;i<=n;i++) sb.append(i);
        String s=sb.toString();
        sb.delete(0,sb.toString().length());
        dfs(0,s);
        return res;
    }

    void dfs(int i,String s){
        if(i==s.length()){
            cnt++;
            if(cnt==k) res=sb.toString();
            return;
        }
        for(int j=0;j<s.length();j++){
            if(vis[j]==1||cnt==k) continue;
            vis[j]=1;
            sb.append(s.charAt(j));
            dfs(i+1,s);
            sb.deleteCharAt(sb.toString().length()-1);
            vis[j]=0;
        }
    }

    int getCount(int n){
        if(n==1) return 1;
        return n*getCount(n-1);
    }
}




