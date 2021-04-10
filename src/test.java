import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums={3,2,1};
        solution.getLeastNumbers(nums,2);

        LinkedList<Integer> stack=new LinkedList();
    }
}


class Solution {
    public void getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result=new int[k];
        for(int i=0;i<k;k++)
            result[i]=arr[i];
        for(int i=0;i<k;i++)
            System.out.println(result[i]);
    }
}