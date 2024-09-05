import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Solution128 {
    
    @Test
    public void test(){
        // a.用hashmap存数组的数，遍历，查找连续序列的第一个数，存入list 。时间复杂度为 O(n).
        // b.遍历list，计算每一个连续序列的长度，取最大值。所有连续序列的长度和小于n，时间复杂度为 O(n).
        int[]nums={100,4,200,1,3,2};
        int[]nums1={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));
    }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], 1);
        }
        List<Integer> aList=new ArrayList<>();
        Set<Integer> aSet=hashMap.keySet();
        for (Integer integer : aSet) {
            if(hashMap.get(integer-1)==null && hashMap.get(integer+1)!=null) aList.add(integer);
        }

        int max=0;
        for (int i = 0; i < aList.size(); i++) {
            int j=0;
            Integer k=aList.get(i);
            while (hashMap.get(k)!=null) {
                j++;
                k++;
            }
            if(max<j) max=j;
        }
        return max;
    }
/*  最长连续序列
 * 给定一个未排序的「整数」数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 */
}
