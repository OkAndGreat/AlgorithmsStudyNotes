import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCasePermutation("9z7u");
        for (String s : strings
        ) {
            System.out.println(s);
        }

    }

}

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        fun(chars, 0);
        return res;
    }

    void fun(char[] chars, int idx) {
        if (idx == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[idx])) {
            fun(chars, idx + 1);
            if (Character.isLowerCase(chars[idx])) {
                chars[idx] = Character.toUpperCase(chars[idx]);
            } else {
                chars[idx] = Character.toLowerCase(chars[idx]);
            }
        }
        fun(chars, idx + 1);
    }
}




