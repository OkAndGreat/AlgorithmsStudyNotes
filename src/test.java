import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("456","77"));
        int a = 1;
        int b = 2;
        a ^= b;
        b ^= a;
        a ^= b;

        char c = '1';
        if(c == '['){

        }else if(c == ']'){

        }else if(c >= '0' && c <= '9'){

        }else{
            System.out.println("hhh");
        }
    }

}

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int res = 0;
        int carry = 0;
        int factor = 1;
        while(i >= 0 && j >= 0){
            int num = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            res += num % 10 * factor;
            carry = num / 10;
            factor *= 10;
            i--;
            j--;
        }
        while(i >= 0){
            res += (num1.charAt(i) - '0') * factor;
            factor *= 10;
            i--;
        }
        while(j >= 0){
            res += (num2.charAt(j) - '0') * factor;
            factor *= 10;
            j--;
        }

        return Integer.toString(res);
    }
}

