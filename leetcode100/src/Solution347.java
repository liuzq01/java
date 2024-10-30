import java.util.Arrays;

import org.junit.Test;

public class Solution347 {
    @Test
    public void test(){
        int[]nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
        int[]nums1={1,1,1,3,3,6,6,8,6,6,14};
        System.out.println(Arrays.toString(topKFrequent(nums1, 3)));
        int[]nums2={1,6,100,24,6,100,6,24,100,6};
        System.out.println(Arrays.toString(topKFrequent(nums2, 4)));
    }
    public int[] topKFrequent(int[] nums, int k) {  // 计数法
        //找最大最小值
        int min=nums[0], max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<min) min=nums[i];
            if(nums[i]>max) max=nums[i];
        }
        //遍历并计数nums中各元素的个数
        int[] arr=new int[max-min+1];
        for (int i = 0; i <nums.length; i++) {
            arr[nums[i]-min]++;
        }
        //通过nums遍历arr那些已计数的元素,找频率前 k 高的元素
        int[] result=new int[k];
        int m=0;
        int maxOfarr=0;
        int lastMax=(int) (Math.pow(2, 32)-1);  // int类型数据的上限
        int temp=0;
        while (k!=0) {
            for (int i = 0; i < nums.length; i++) {
                if (arr[nums[i]-min]>maxOfarr && arr[nums[i]-min]<lastMax) {    
                    maxOfarr=arr[nums[i]-min];
                    temp=nums[i];
                }
            }
            result[m]=temp;    
            lastMax=maxOfarr;
            maxOfarr=0;
            m++; k--;
        }
        return result;
    }
}
/*
 * 347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 

进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。


 */

