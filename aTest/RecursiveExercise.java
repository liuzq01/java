import java.util.Random;
import org.junit.Test;

public class RecursiveExercise {
    @Test
    public void test(){
        //递归式冒泡排序
        int[] arr = generateArrary();
        recursiveBubbleSort(arr);
        printArrary(arr);
    }
    public int[] generateArrary(){
        int[] arr =new int[20];
        Random random= new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(101);
        }
        return arr;
    }
    public void printArrary(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
            if ((i+1)%5==0) {
                System.out.println();
            }
        }
    }
    public void recursiveBubbleSort(int[] arr){
        recursiveBubbleSort(arr, arr.length);
    }
    private void recursiveBubbleSort(int[] arr, int n){
        for (int i = 0; i < n-1; i++) {
            if (arr[i]>arr[i+1]) {
                swap(arr,i,i+1);
            }
        }
        if(n>=3) recursiveBubbleSort(arr, n-1);
    }
    public void swap(int[] arr ,int i,int j){
        int temp=0;
        temp=arr[j]; arr[j]=arr[i]; arr[i]=temp;
    }
    @Test
    public void test1(){
        //递归式选择排序
        int[] arr=generateArrary();
        recursiveSelectSort(arr);
        printArrary(arr);
    }
    public void recursiveSelectSort(int[] arr){
        recursiveSelectSort(arr, arr.length);
    }
    private void recursiveSelectSort(int[] arr,int n){
        int temp=arr[0], p=0;
        for (int i = 1; i < n; i++) {
            if (arr[i]>temp) {
                temp=arr[i];
                p=i;
            }
        }
        swap(arr, p, n-1);
        if(n>=3) recursiveSelectSort(arr, n-1);
    }
    @Test
    public void test2(){
        //递归式插入排序
        int[]arr = generateArrary();
        recursiveInsertSort(arr);
        printArrary(arr);
    }
    public void recursiveInsertSort(int[] arr){
        recursiveInsertSort(arr,1);
    }
    private void recursiveInsertSort(int[] arr, int n){
        for (int i = n; i >0; i--) {        //a[n]是待插入的数，a[n]之前的数已经排好序
            if (arr[i]<arr[i-1]) {
                swap(arr, i, i-1);
            }
            else break;
        }
        if(n<=arr.length-2) recursiveInsertSort(arr,n+1);
    }
}
