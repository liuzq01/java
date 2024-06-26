import org.junit.Test;

public class Solution53 {
    @Test
    public void test(){
        /*  最大子数组和
        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出：6
        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        输入：nums = [1]
        输出：1
        输入：nums = [5,4,-1,7,8]
        输出：23
         */
        //int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums={1};
        int[] nums={5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        //遍历数组，求出所有连续子数组的和，记录最大值
        int sum=0,  max=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {     //连续子数组: [i,j]
                sum=sumOfSubArray(i,j,nums);
                if(sum>max) max=sum;
            }
        }
        return max;
    }
    private int sumOfSubArray(int i, int j, int[]nums){
        int sum=0;
        for (int k = i; k <=j; k++) {
            sum=sum+nums[k];
        }
        return sum;
    }
}
