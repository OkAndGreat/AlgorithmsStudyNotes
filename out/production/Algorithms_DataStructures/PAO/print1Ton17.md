/**
*输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

*
* 示例 1:
*
* 输入: n = 1
* 输出: [1,2,3,4,5,6,7,8,9]
*
* 说明：
*
* 用返回一个整数列表来代替打印
* n 为正整数
* 通过次数102,536提交次数131,420
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  */

````java
/**
 * 这道题实际面试时要考虑大数
 *
 */

//我的解法 不考虑大数
class Solution {
    public int[] printNumbers(int n) {
        int x = (int) Math.pow(10, n);
        int[] result = new int[x - 1];
        for (int i = 1; i < x; i++)
            result[i - 1] = i;
        return result;
    }
}

//大佬的解法，考虑大数
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
````

