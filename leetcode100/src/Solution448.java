import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class Solution448 {
    @Test
    public void test(){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums).toString());
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[1, n]的整数存入hashSet，遍历数组，删去hashSet中对应的数，剩余的即为所求
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(i+1);
        }
        for (int i = 0; i < nums.length; i++) {
            hashSet.remove(nums[i]);
        }
        List<Integer> list=new ArrayList<>();
        for (Integer integer : hashSet) {
            list.add(integer);
        }
        return list;
    }
}
/*
 * 448. 找到所有数组中消失的数字
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

示例 1：

输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
示例 2：

输入：nums = [1,1]
输出：[2]
 
进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */

