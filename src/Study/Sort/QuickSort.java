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

        //测试冒泡排序
//        sort(arr, 0, arr.length - 1);
        sort(arr,0, arr.length - 1);

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
        if(l >= r) return;

        int temp = arr[l];
        int left = l;
        int right = r;
        while(left < right){
            while(left < right && arr[right] > temp) right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= temp) left++;
            arr[right] = arr[left];
        }
        arr[left] = temp;
        sort(arr,l,left-1);
        sort(arr,left+1,r);
    }

    public static void Quicksort(int[] arr,int l,int r){
        if(l >= r) return;
        int p = l;
        int q = r;
        int temp = arr[p];
        while(p != q){
            while(arr[q] <= temp && p != q) q--;
            arr[p] = arr[q];
            while (arr[p] > temp && p != q) p++;
            arr[q] = arr[p];
        }
        arr[p] = temp;
        Quicksort(arr,l,p - 1);
        Quicksort(arr,p + 1,r);
    }

    //得到 [min.max]内的整数
    public static int getRandowNum(int min,int max){
        Random random = new Random();
        int j = random.nextInt(max - min + 1);
        j = j + min;
        return j;
    }

    public static void shuffle(int[] nums){
        for(int i = 0;i < nums.length;i++){
            int j = getRandowNum(i,nums.length - 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
