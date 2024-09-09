import org.junit.Test;

public class Solution136 {
    
    @Test
    public void test(){
        int[] nums={4,1,2,1,2};
        int[] nums1={3};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber(nums1));
    }
    public int singleNumber(int[] nums) {
        /* 异或运算（ ^ ）
         * a^a=0, a^b=1,a^b^a=a^a^b=0^b=b（a、b为0或1）
         * 也可以用同或运算(异或的否定)解决此题，java中没有直接提供同或运算符
         */
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result=result^nums[i];
        }
        return result;
    }
/*  只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。除了某个元素只出现一次以外，其余每个元素均出现两次。

输入：nums = [2,2,1]
输出：1

输入：nums = [4,1,2,1,2]
输出：4

输入：nums = [1]
输出：1
 */
}
