import java.io.File;
import java.util.*;

//[9]
//[1,9,9,9,9,9,9,9,9,9]
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]
                {{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }

}

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        //可能发生数组越界的问题
//        Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return a[1] - b[1];
//            }
//        });
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int cur = 0;
        int minCount = 1;
        for (int i = 1; i < points.length; i++) {
            //没有重叠
            if (points[cur][1] < points[i][0]) {
                cur = i;
                minCount++;
            }
        }

        return minCount;
    }
}

