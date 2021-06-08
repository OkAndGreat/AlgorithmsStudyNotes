import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String S="34123";
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        for(char c:chars) System.out.println(c);
        //solution.permutation(S);
    }

}

class Solution {
    ArrayList<String> res;
    //0表示还未放 1则相反
    int[] vis;
    StringBuilder sb=new StringBuilder();
    public String[] permutation(String S) {
        res=new ArrayList();
        vis=new int[S.length()];
        char[] chars=S.toCharArray();
        Arrays.sort(chars);
        dfs(0,chars);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int idx,char[] chars){
        if(idx==chars.length){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            //考虑重复字符串
            if(vis[i]==1||(chars[i]==chars[i-1]&&vis[i-1]==0)) continue;
            sb.append(chars[i]);
            vis[i]=1;
            dfs(idx+1,chars);
            vis[i]=0;
            sb.deleteCharAt(sb.toString().length()-1);
        }
    }
}




