import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.reverseLeftWords("1",2);
    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
//        StringBuilder sb=new StringBuilder();
//        sb.append(s.substring(n-1,s.length()-1));
//        sb.append(s.substring(0,n-1));

        System.out.println(getManIn3(1,3,2));
        return "sb.toString()";
    }

    int getManIn3(int a,int b,int c){
        return a>b?(Math.max(a, c)):(Math.max(b, c));
    }
}