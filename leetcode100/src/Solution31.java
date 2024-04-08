import org.junit.Test;

class Solution31 {
    @Test
    public void test()
    {
        //下一个排列
/*
        输入：nums = [1,2,3]
        输出：[1,3,2]
        输入：nums = [3,2,1]
        输出：[1,2,3]
        输入：nums = [1,1,5]
        输出：[1,5,1]
*/
        int[] nums={1,2,3};
        //int[] nums={3,2,1};
        //int[] nums={1,1,5};
        nextPermutation(nums);
        for(int k:nums) System.out.printf("%d ",k);
    }
    public void nextPermutation(int[] nums) {

    }
}