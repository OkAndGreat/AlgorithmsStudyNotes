import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));
    }
}


class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return fun(x, n, x);
        } else {
            return fun(1.0 / x, -n, 1.0 / x);
        }
    }

    double fun(double x, int n, double num) {
        if (n == 0) return x;
        if (n == 1) return x * num;
        if(n==2) return x*num*num;
        int cnt = 1;
        double store = num;
        while (cnt * 2 <= n) {
            x *= num;
            num *= num;
            cnt *= 2;
        }
        return fun(x, n - cnt, store);
    }
}