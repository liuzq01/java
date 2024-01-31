import java.util.Random;

import org.junit.Test;

public class MergeSort1 {
    @Test
    public void test(){
        //归并排序（改进）
        int[] arr=new int[20];
        Random random =new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101);
        }
        mergeSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0) {
                System.out.println();
            }
        }
    }
    private void mergeSort1(int[] a)        //递归函数的辅助函数
    {
        int[] arr_temp =new int[a.length];
        int left=0,right=a.length-1; 
        mergeSort1(a,arr_temp,left,right);
    }
    private void mergeSort1(int[] a, int[] arr_temp, int left, int right)       //递归函数
    {
        if (left<right) {
            int middle=(left+right)/2;
            mergeSort1(a, arr_temp, left,  middle);
            mergeSort1(a, arr_temp, middle+1,  right);
            merge(a,arr_temp,left,right);
            }
    }
    private void merge(int[] a, int[] arr_temp, int left, int right) {      //合并函数
        int middle=(left+right)/2;
        int i=left,j=middle+1,k=0;
        while (i<=middle && j<=right) {   //比较数组a的[left,middle]、[middle+1,right]这两段数据，从小到大存入arr_temp数组
            if (a[i]<=a[j]) {
                arr_temp[k]=a[i];
                i++;k++;
            }
            else {
                arr_temp[k]=a[j];
                j++;k++;
            }
        }
        if (i>middle) {     //[middle+1,right]这段数据的剩余部分，依次存入arr_temp数组
            while (j<=right) {
                arr_temp[k]=a[j];
                j++;k++;
            }
        }
        if (j>right) {      //[left,middle]这段数据的剩余部分，依次存入arr_temp数组
            while (i<=middle) {
                arr_temp[k]=a[i];
                i++;k++;
            }
        }
        for(i=left;i<=right;i++)        //排好序之后，复制回数组a
        {
            a[i]=arr_temp[i-left];
        }
    }
}
