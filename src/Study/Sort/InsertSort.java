package Study.Sort;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

/**
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for(int i =0; i < 8000000;i++) {
            arr[i] = (int)(Math.random() * 800000000); //生成一个[0, 8000000) 数
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
        for(int i=1;i<arr.length;i++){
            int value=arr[i];
            int pointer=i-1;
            while(pointer>=0&&arr[pointer]>value) {
                arr[pointer+1]=arr[pointer];
                pointer--;
            }
            if(pointer>=0) arr[pointer+1]=value;
            else arr[0]=value;
        }
    }
}
