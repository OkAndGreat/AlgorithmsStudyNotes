import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character,Integer> hashmap = new HashMap();
        int res = 0;

        while(j < s.length()){
            while(j < s.length() && hashmap.getOrDefault(s.charAt(j),0) == 0){
                hashmap.put(s.charAt(j),1);
                j++;
            }
            res = Math.max(res,j-i);
            while(s.charAt(i) != s.charAt(j)){
                hashmap.remove(s.charAt(i));
                i++;
            }
            hashmap.remove(s.charAt(i));
            i++;
        }

        return res;
    }
}