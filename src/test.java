import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs=new String[]{"1"};

    }

}

class Solution {
    List<String> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    String[] strs = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        dfs(digits,0);
        return res;
    }

    void dfs(String str,int idx){
        if(idx==str.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i<strs[Integer.parseInt(String.valueOf(str.charAt(idx)))-2].length(); i++){
            sb.append(strs[Integer.parseInt(String.valueOf(str.charAt(idx)))-2].charAt(i));
            dfs(str,idx+1);
            sb.deleteCharAt(sb.toString().length()-1);
        }
    }
}




