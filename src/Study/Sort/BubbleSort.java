package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * 八万个数据排序
 * 排序前的时间是=2021-02-17 23:53:14
 * 排序后的时间是=2021-02-17 23:53:24
 *10秒左右
 */
public class BubbleSort {
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
        int Length = arr.length;
        int temp;
        //用来指示一轮排序下来是否有过交换,若没有(即flag==true),则停止排序
        boolean flag=true;
        for (int i = 0; i < Length - 1; i++) {
            for (int j = 0; j < Length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(flag==true){
                break;
            }
            else {
                flag=true;
            }
        }
    }
}

