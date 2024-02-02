import org.junit.Test;

public class RecursiveExercise1 {
    @Test
    public void Test(){
        //二分查找
        RecursiveExercise rec=new RecursiveExercise();
        //int[] arr = rec.generateArrary();
        int[]arr={32, 67 ,81 ,10 ,18 ,43 ,20, 7 ,42 ,72, 9 ,60 ,53 ,14 ,17, 74 ,91 ,36 ,50 ,91};
        rec.recursiveInsertSort(arr);
        int target=20;
        int index = recrusiveBinarySort(arr, target);
        if (index==-1) {
            System.out.println("查无此数");
        }
        else System.out.println("位置是： "+index);
        rec.printArrary(arr);
    }
    public int recrusiveBinarySort(int[]a, int target){
        return recrusiveBinarySort(a, 0, a.length-1, target);
    }
    private int recrusiveBinarySort(int[] a, int left, int right,int target){
        int middle=(left+right)/2;
        int index=0;
        if (left<=right) {
            if (target==a[middle]) {
                index=middle;
            }
            else if (target<a[middle]) {
                return recrusiveBinarySort(a, left, middle-1, target);
            }
            else {
                return recrusiveBinarySort(a, middle+1, right, target);
            }
            }
        else index=-1;
        return index;
    }
}
