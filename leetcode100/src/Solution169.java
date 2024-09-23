import java.util.HashMap;
import org.junit.Test;

public class Solution169 {
    @Test
    public void test(){
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        //遍历数组，计数各元素并存入hashmap;再遍历hashMap，找出个数最大者。
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) hashMap.put(nums[i], hashMap.get(nums[i])+1);
            else hashMap.put(nums[i], 1);
        }
        int max=hashMap.get(nums[0]);
        int key0=nums[0];
        for (Integer i:hashMap.keySet()) {
            if (hashMap.get(i)>max) {
                max=hashMap.get(i);
                key0=i;
            }
        }
        return key0;
    }
}
/*  多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

输入：nums = [3,2,3]
输出：3

输入：nums = [2,2,1,1,1,2,2]
输出：2
 */
