import java.util.*;

public class test {
    public static void main(String[] args) {
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().findContinuousSequence(9));
    }

}

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int left = 1;
        int right = 2;
        int cur = 1;

        while(right <= target / 2 + 1){
            if(cur > target){
                cur -= left;
                left++;
                continue;
            }
            if(cur == target){
                int[] temp = new int[right - left];
                int idx = 0;
                for(int i = left;i < right;i++) temp[idx++] = i;
                res.add(temp);
                cur -= left;
                left++;
                continue;
            }
            cur += right;
            right++;
        }

        return res.toArray(new int[res.size()][]);
    }
}