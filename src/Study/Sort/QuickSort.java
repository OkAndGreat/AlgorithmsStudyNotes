package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 八百万个数据排序
 * 排序前的时间是=2021-05-02 09:04:01
 * 排序后的时间是=2021-05-02 09:04:02
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 800000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        sort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));
    }

    //循环中每一语句都检查一次l<r
    public static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int temp = arr[l];
        int left = l;
        int right = r;
        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            if (l < r) arr[l] = arr[r];
            while (l < r && arr[l] < temp) l++;
            if (l < r) arr[r] = arr[l];
        }
        //循环退出时 r==l
        arr[l] = temp;
        //向左递归
        sort(arr, left, l);
        //向右递归
        sort(arr, l + 1, right);


    }
}
