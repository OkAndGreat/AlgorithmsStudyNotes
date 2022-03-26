package Study.Sort;


import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

    static int[] res;
    static int i = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1,2,6,8,5,6,3};
        int[] temp = new int[]{3,5,1,2,6,8,5,6,3};
        res = new int[8];
        //方便观察结果
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));

        //shuffle后的结果
//        shuffle(nums);
//        System.out.println(Arrays.toString(nums));

        selectArray(nums,0,nums.length-1,7);

        System.out.println(Arrays.toString(res));

//        System.out.println(select(nums,0,nums.length-1,4));

    }

    //就是快排稍微改动

    static void selectArray(int[] arr,int l,int r,int k){
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

        if(k > left){
            selectArray(arr,left + 1,r,k);
        }
        if(k < left){
            selectArray(arr,l,left - 1,k);
        }
        if(k == left){
            for(int i = 0;i <= k;i++){
                res[i] = arr[left--];
            }
        }

    }

    static int select(int[] arr,int l,int r,int k){
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

        if(k > left){
            return select(arr,left + 1,r,k);
        }
        if(k < left){
            return select(arr,l,left - 1,k);
        }

        return arr[left];

    }

    static void shuffle(int[] arr){
        Random random = new Random();
        for(int i = 0;i < arr.length;i++){
            int j = i + random.nextInt(arr.length - i);
            swap(arr,i,j);
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
