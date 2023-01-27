package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 八百万个数据排序
 * 排序前的时间是=2021-05-02 09:04:01
 * 排序后的时间是=2021-05-02 09:04:02
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[800];
        for (int i = 0; i < 800; i++) {
            arr[i] = (int) (Math.random() * 800); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shuffle(arr);
        //测试冒泡排序
//        sort(arr, 0, arr.length - 1);
        Quicksort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        System.out.println(Arrays.toString(arr));

//        int[] shuffleArray = new int[]{5,4,3,2,1,0};
//        shuffle(shuffleArray);
//        System.out.println(Arrays.toString(shuffleArray));
    }

    //平均时间复杂度和最好时间复杂度 Onlog2n  最坏时间复杂度 On2
    public static void sort(int[] arr, int l, int r) {
        if (l >= r) return;

        int temp = arr[l];
        int left = l;
        int right = r;
        while (left < right) {
            while (left < right && arr[right] > temp) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) left++;
            arr[right] = arr[left];
        }
        arr[left] = temp;
        sort(arr, l, left - 1);
        sort(arr, left + 1, r);
    }

    public static void Quicksort(int[] arr, int l, int r) {
        if (l >= r) return;
        int left = l;
        int right = r;
        int temp = arr[l];

        while (l < r) {
            while (l < r && arr[r] > temp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= temp) l++;
            arr[r] = arr[l];
        }
        arr[l] = temp;
        Quicksort(arr, left, l - 1);
        Quicksort(arr, l + 1, right);
    }

    public static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int index = i + random.nextInt(nums.length - i);
            nums[i] ^= nums[index];
            nums[index] ^= nums[i];
            nums[i] ^= nums[index];
        }
    }
}
