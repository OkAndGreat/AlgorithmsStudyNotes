package PAO;

/**
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

*
*
* 示例：
*
* 输入：nums =[1,2,3,4]
* 输出：[1,3,2,4]
* 注：[3,1,2,4] 也是正确的答案之一。
*
*
* 提示：
*
* 0 <= nums.length <= 50000
* 1 <= nums[i] <= 10000
* 通过次数119,308提交次数185,928
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  */

````java
//我的解法
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums;
        int temp;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            while (nums[left] % 2 != 0 && left != right) {
                left++;
            }
            if (left == right) break;
            while (nums[right] % 2 == 0 && left != right) {
                right--;
            }
            if (left == right) break;
            nums[right] = nums[right] + nums[left];
            nums[left] = nums[right] - nums[left];
            nums[right] = nums[right] - nums[left];
        }
        return nums;
    }
}

//大佬的解法
class Solution {
  public int[] exchange(int[] nums) {
    int p = 0;
    int len = nums.length;
    for(int i = 0; i < len; i ++){
      if((nums[i]&1)==1){
        int tmp = nums[i];
        nums[i] = nums[p];
        nums[p++] = tmp;
      }
    }
    return nums;
  }
}

//不是很看得懂
//
````