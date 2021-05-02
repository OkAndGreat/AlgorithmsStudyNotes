package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

//Radixsort注意不要用Math.pow去处理数的去除最后一位
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 800000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        sort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

    }
}
