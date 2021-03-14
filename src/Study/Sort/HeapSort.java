package Study.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 排序前的时间是=2021-03-14 10:21:35
 * 排序后的时间是=2021-03-14 10:21:35
 * 八十万的数据不到一秒
 *
 *排序前的时间是=2021-03-14 10:22:11
 * 排序后的时间是=2021-03-14 10:22:13
 * 八百万个数据2秒
 *
 * 排序前的时间是=2021-03-14 10:22:41
 * 排序后的时间是=2021-03-14 10:23:10
 * 八千万个数据30秒
 */
public class HeapSort {
    public static void main(String[] args) {
//要求将数组进行升序排序
        //int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 800000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        //System.out.println("排序后=" + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int temp;
        //首先将arr弄成大顶堆的形式
        for(int i=arr.length/2-1;i>=0;i--){
            adjustTree(arr,i,arr.length);
        }
//每次将最大的元素沉到数组末端然后“拿走” 再对余下的数组进行调整让最大的元素沉到末尾循环最后数组有序
        for(int j = arr.length-1;j >0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustTree(arr, 0, j);
        }
    }

    private static void adjustTree(int[] arr,int i,int length){
        int temp=arr[i];
        //i*2+1代表i所代表的节点的左子节点
        //让k=k*2+1表明移动到当前节点的左节点
        for(int k=i*2+1;k<length;k=k*2+1){
            //首先让左子节点和右子节点比较
            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }
            //这里不能使用 arr[i] 因为i的值会变化
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                //因为我们的排序是从下到上，从左到右的，所以可以直接break
                break;
            }
        }
        arr[i]=temp;
    }
}
