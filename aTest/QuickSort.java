import java.util.Random;
import org.junit.Test;

public class QuickSort {
    @Test
    public void test(){             //快排
        int[] arr=new int[20];
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101);
        }
        quickSort(arr); 
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0) {
                System.out.println();
            }
        }
    }
    private void quickSort(int[] a){
        int left=0,right=a.length-1;
        quickSort(a, left, right);
    }
    private void quickSort(int[] a,int left,int right){
        if ((right-left)>=3) {
            int pivot=middleValue(a, left, right);
            swap(a,right,pivot);    //先把基准值放在最右边，再排序
            pivot=right;
            int i=left,j=right-1;
            while (i<j) {
                while (a[i]<a[pivot] && i<right) {
                    i++;
                }
                while (a[j]>a[pivot] && j>left) {
                    j--;
                }
                if(i<j) swap(a,i, j);
            }
            swap(a,i, pivot);
            pivot=i;
            quickSort(a, left, pivot-1);
            quickSort(a, pivot+1, right);
        }
        if ((right-left)==2 || (right-left)==1) {
            middleValue(a, left, right);
        }
    }
    private int middleValue(int[] a,int left,int right){
        int middle=(left+right)/2;  //使用插入排序法，给a的左、中、右三个数排序，取中值为基准值
        if (a[left]>a[middle]) swap(a,left, middle);
        if (a[right]<a[middle]) swap(a,right,middle);
        if (a[middle]<a[left]) swap(a,middle,left);
        return middle;
    }
    private void swap(int[] b, int i, int j) {
        int temp=0;
        temp=b[j];b[j]=b[i];b[i]=temp;
    }
}
