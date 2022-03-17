package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//分为 归和并 俩个步骤
//理解递归时方法栈的调用
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80];
        for (int i = 0; i < 80; i++) {
            arr[i] = (int) (Math.random() * 800); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left >= right) return;
        int mid = (left + right) >>> 1;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid + 1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        while(j <= right){
            temp[t++] = arr[j++];
        }

        while(left <= right) {
            arr[left] = temp[left];
            left++;
        }
    }

//    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            mergeSort(arr, left, mid, temp);
//            mergeSort(arr, mid + 1, right, temp);
//            merge(arr, left, mid, right, temp);
//        }
//    }
//
//    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//        int l = left;
//        int j = mid + 1;
//        int t = 0;
//        while (l <= mid && j <= right) {
//            if (arr[l] < arr[j]) temp[t++] = arr[l++];
//            else temp[t++] = arr[j++];
//        }
//        while( l <= mid)temp[t++] = arr[l++];
//        while( j <= right) temp[t++] = arr[j++];
//        t=0;
//        while(left<=right) arr[left++]=temp[t++];
//    }
}
