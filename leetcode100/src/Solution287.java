import org.junit.Test;

public class Solution287 {
    @Test
    public void test(){
        int[] nums={1,3,4,2,2};
        int[] nums1={3,1,3,4,2};
        int[] nums2={3,3,3,3,3};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate(nums1));
        System.out.println(findDuplicate(nums2));
    }
    public int findDuplicate(int[] nums) {
        // 遍历数组，逐个检查
        int result=0;
        for (int i = 1; i < nums.length; i++) {
            int k=0;
            for (int j = 0; j < nums.length; j++) {
                if(i==nums[j])  k++;
                if(k==2) {
                    result=i;
                    break;
                }
            }
            if(k==2) break;
        }
        return result;
    }
}
/*  寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
进阶：
如何证明 nums 中至少存在一个重复的数字?
你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 

输入：nums = [1,3,4,2,2]
输出：2

输入：nums = [3,1,3,4,2]
输出：3

输入：nums = [3,3,3,3,3]
输出：3
 
 */
