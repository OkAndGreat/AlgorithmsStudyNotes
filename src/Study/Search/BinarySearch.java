package Study.Search;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> resultsList = new ArrayList<>();
        binarySearch(arr, 0, arr.length - 1, 1, resultsList);
        Object[] resultArray = resultsList.toArray();
        Arrays.sort(resultArray);
        int[][] test={{1,2,3,4},{4,5,6,7}};
        //System.out.println(Arrays.deepToString(test));
        System.out.println(Arrays.toString(resultArray));

    }

    //二分查找的递归实现
    /**
     * @param arr         二分查找的数组
     * @param l           左指针
     * @param r           右指针
     * @param value       要找的值
     * @param resultsList 要找的值对应的下标数组
     */
    private static void binarySearch(int[] arr, int l, int r, int value, ArrayList<Integer> resultsList) {
        //推出递归的条件是左指针对应的下标不再小于右指针对应的下标
        if (l < r) {
            int mid = (l + r) / 2;
            if (value < arr[mid]) {
                binarySearch(arr, l, mid, value, resultsList);
            } else if (value > arr[mid]) {
                binarySearch(arr, mid, r, value, resultsList);
            } else {
                resultsList.add(mid);
                //向左遍历寻找目标值对应的下标
                int i=mid;
                while ((i-1>=0)&&arr[i - 1] == value) {
                    i--;
                    resultsList.add(i);
                }
                ///向右遍历寻找目标值对应的下标
                int j=mid;
                while ((j+1<=arr.length-1)&&arr[j + 1] == value) {
                    j++;
                    resultsList.add(j);
                }
            }
        }

    }
}
