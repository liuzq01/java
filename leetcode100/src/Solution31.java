import org.junit.Test;

public class Solution31 {
    @Test
    public void test(){
        //下一个排列
/*
        输入：nums = [1,2,3]
        输出：[1,3,2]
        输入：nums = [5,4,3,2,1]  
        输出：[1,2,3,4,5]
        输入：nums = [12,5,8,6,4]
        输出：[12,6,4,5,8]
*/
        //int[] nums={1,2,3};
        //int[] nums={5,4,3,2,1};
        int[] nums={12,5,8,6,4};
        nextPermutation(nums);
        for(int k:nums) System.out.printf("%d ",k);
    }
    public void nextPermutation(int[] nums) {
        /*用十进制数类比：最低位的数字(个位上的数)往左移，遇到比它大的，不停；   ①
        遇到比它小的，插队在它前面，并将此数后面的所有数字排序(正序)；          ②
        没有比它小的，先恢复原来的样子，再移动十位上的数，以此类推。            ③
        */
        //先检查是不是最大的排列（倒序的），是的，把它变成最小排列（正序的）     ④
        boolean max=true;
        for (int i = 0; i < nums.length-1; i++) {   // ④
            if (nums[i]<nums[i+1]){
                max=false;
                break;
            } 
        }
        if (max) {  
            insertSort(nums,0,nums.length);
        }
        else{   
            for (int k = nums.length-1; k >=1; k--) {
                for (int i = k; i >=1; i--) {
                    if (nums[i]<=nums[i-1]) {   //  ①
                        swap(nums, i, i-1);     
                        if (i==1) {     //  ③  nums[k]左边的数全都比它大，nums[k]移动到最左边时，需要恢复原位
                            for (int j = 0; j < k; j++) {
                                swap(nums, j, j+1);
                            }
                        }
                    }
                    else {      //   ②
                        swap(nums, i, i-1);
                        insertSort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
    }
    private void insertSort(int[] nums,int left, int right){      // 给nums的[left,right)的数插入排序，正序
        for (int k = left; k < right-1; k++) {
            for (int i = k; i >= left; i--) {
            if (nums[i+1]<nums[i]) swap(nums, i+1, i);
            }
    }
}
    private void swap(int[]nums,int i,int j){
        int temp=0;
        temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}
