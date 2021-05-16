package PAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * <p>
 * 通过次数116,916提交次数270,034
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
   
```
class frogs {
    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("前的时间是=" + date1Str);
//        System.out.println(solution1.numWays(41));
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("后的时间是=" + date2Str);
//        前的时间是=2021-03-27 15:24:29
//        267914296
//        后的时间是=2021-03-27 15:24:31

//        Solution2 solution2 = new Solution2();
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("前的时间是=" + date1Str);
//        System.out.println(solution2.numWays(1000)%1000000007);
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("后的时间是=" + date2Str);

        Solution3 solution3 = new Solution3();
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("前的时间是=" + date1Str);
        System.out.println(solution3.numWays(7)%1000000007);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("后的时间是=" + date2Str);
    }
}

/**
 * 动态规划递归解法(使用备忘录算法)
 */
class Solution2 {
    HashMap<Integer,Integer> cache=new HashMap<>();
    public int numWays(int n) {
        if(n==0||n==1){
            return 1;
        }
        if(cache.get(n)!=null){
            return cache.get(n);
        }else {
            int i=numWays(n-1);
            int j=numWays(n-2);
            cache.put(n-1,i);
            cache.put(n-2,j);
            return i+j;
        }
    }
}

/**
 * 动态规划迭代解法
 */
class Solution3 {
    public int numWays(int n) {
        if(n==0||n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=1;
        int b=2;
        int temp = 0;
        for(int i=3;i<=n;i++){
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }
}

/**
 * 暴力解法
 * 力扣提交超出时间限制
 */
class Solution1 {
    int result = 0;
    int num = 0;
    int n;

    public int numWays(int n) {
        this.n = n;
        dfs(1);
        num--;
        dfs(2);
        return n==0?1:result;
    }

    void dfs(int i) {
        num+=i;
        if (judge(num)) {
            if (num == n) {
                result++;
                return;
            }
            dfs(1);
            num--;
            dfs(2);
            num-=2;
        }

    }

    boolean judge(int num) {
        return num <= n;
    }
}
```


