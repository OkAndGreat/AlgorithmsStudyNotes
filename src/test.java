import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
    }
}



class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length==1) return nums;
        int temp;
        int left=0;
        int right=nums.length-1;
        while(true){
            while(nums[left]%2!=0&&left!=right){
                left++;
            }
            if(left==right) break;
            while(nums[right]%2==0&&left!=right){
                right--;
            }
            if(left==right) break;
            nums[right]=nums[right]+nums[left];
            nums[left]=nums[right]-nums[left];
            nums[right]=nums[right]-nums[left];
        }
        return nums;
    }
}
