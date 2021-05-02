package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

//又叫最小增量排序
//是对插入排序的改进，防止有较小的数在较后面的位置

/**
 * 八百万数据
 * 排序前的时间是=2021-05-02 10:11:01
 * 排序后的时间是=2021-05-02 10:11:04
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for(int i =0; i < 8000000;i++) {
            arr[i] = (int)(Math.random() * 80000000); //生成一个[0, 8000000) 数
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
            int j = 0;
            int temp = 0;
            //分组
            for (int increment = arr.length / 2; increment > 0; increment /= 2) {
                //System.out.println("increment:" + increment);
                //表示对每组进行希尔排序
                for (int i = increment; i < arr.length; i++) {
                    // System.out.println("i:" + i);
                    temp = arr[i];

                    //当从这一层循环出来时说明已经找到要插入的位置
                    for (j = i - increment; j >= 0; j -= increment) {
                        if (temp < arr[j]) {
                            arr[j + increment] = arr[j];
                        } else {
                            break;
                        }
                    }
                    arr[j + increment] = temp;
                }
            }
        }
}
