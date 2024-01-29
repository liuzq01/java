import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class MergeSort {
    @Test
    public void test1()
    {
        //归并排序
        int[] arr=new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101);
        }
        arr = mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0 ) {
                System.out.println();
            }
        }
    }
    public int[] mergeSort(int[] a)
    {
        if (a.length==1) {
            return a;
        }
        else 
        {
            int middle =a.length/2;
            return merge(mergeSort(Arrays.copyOfRange(a, 0, middle)),mergeSort(Arrays.copyOfRange(a, middle, a.length)));
            // Arrays.copyOfRange 方法接受三个参数：原始数组，起始索引（包括），结束索引（不包括）。(左闭右开)
        }
    }
    public int[] merge(int[] b, int[] c) {
        int l=b.length+c.length;                   
        int[] arr_temp=new int[l];                
        int i=0,j=0,k=0;
        while (i<b.length && j<c.length) {
            if (b[i]<=c[j]) {
                arr_temp[k]=b[i];
                i++; k++;
            }
            else {
                arr_temp[k]=c[j];
                j++; k++;
            }
        }
        if (i==b.length && j<c.length) {
            while(j<c.length){
                arr_temp[k]=c[j];
                j++; k++;
                }
        }
        if (i<b.length && j==c.length) {
            while(i<b.length){
                arr_temp[k]=b[i];
                i++; k++;
                }
        }
        return arr_temp;
    }
}
