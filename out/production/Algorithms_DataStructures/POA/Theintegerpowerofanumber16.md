/**
*实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

*
*
*
* 示例 1：
*
* 输入：x = 2.00000, n = 10
* 输出：1024.00000
* 示例 2：
*
* 输入：x = 2.10000, n = 3
* 输出：9.26100
* 示例 3：
*
* 输入：x = 2.00000, n = -2
* 输出：0.25000
* 解释：2-2 = 1/22 = 1/4 = 0.25
*
*
* 提示：
*
* -100.0 <x< 100.0
* -231<= n <=231-1
* -104<= xn<= 104
*
*
* 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
*
* 通过次数79,005提交次数235,660
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  */

````java

//我的第一次提交 超时
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

//我改进后的代码
//对于1.00000 2147483647 这个测试案例任然超时
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return fun(x, n);
        } else {
            return fun(1.0 / x, -n);
        }
    }

    double fun(double x, int n) {
        int cnt = 1;
        double num = x;
        while (cnt * 2 < n + 1) {
            x *= x;
            cnt *= 2;
        }
        while (cnt < n) {
            x *= num;
            cnt++;
        }
        return x;
    }
}

//再次改进后的代码

````

