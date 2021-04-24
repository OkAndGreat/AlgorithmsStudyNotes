import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="123";
        System.out.println(s.substring(0,1));
        StringBuilder stringBuilder = new StringBuilder();
    }
}

class Solution {
    HashMap<Character,Boolean> hashMap=new HashMap();
    public char firstUniqChar(String s) {
        char c;
        Boolean flag=true;
        if(s.length()==0) return ' ';
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(hashMap.containsKey(c)) continue;
            hashMap.put(c,true);
            for(int j=i+1;i<s.length();j++){
                if(s.charAt(j)==c){
                    flag=false;
                    break;
                }
            }
            if(flag) return c;
        }
        return ' ';
    }
}