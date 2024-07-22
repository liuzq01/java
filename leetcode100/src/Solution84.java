
import org.junit.Test;

public class Solution84 {
    @Test
    public void test(){
/*      柱状图中最大的矩形
    * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
        求在该柱状图中，能够勾勒出来的矩形的最大面积。
        输入：heights = [2,1,5,6,2,3]
        输出：10
        解释：最大的矩形为图中红色区域，面积为 10
        输入： heights = [2,4]
        输出： 4
 */
        //int[] heights={2,1,5,6,2,3};
        int[] heights={2,4};
        System.out.println(largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        // 先遍历所有单个柱子的面积，即时取最大值；再遍历所有相邻的2个柱子，计算所勾勒矩形的面积，即时取最大值；
        // 再遍历所有相邻的3个柱子...
        int temp=0;
        int max=largestRectangleArea(heights, 1);
        for (int i = 2; i <= heights.length; i++) {
            temp=largestRectangleArea(heights, i);
            if(temp>max) max=temp;
        }
        return max;
    }
    private int largestRectangleArea(int[] heights,int n) {
        // 遍历所有相邻的n个柱子
        int start=0,end=0;  
        int temp=0;
        int max=countArea(heights, 0, n-1);
        for (start = 1; start <= heights.length-n; start++) {
            end=start+n-1;
            temp=countArea(heights, start, end);
            if(temp>max) max=temp;
        }
        return max;
    }
    private int countArea(int[] heights,int start,int end){
        // 遍历所给元素，寻找其中的最小值
        int min=heights[start];
        for (int i = start+1; i <= end; i++) {
            if(heights[i]<min) min=heights[i];
        }
        return min*(end-start+1);
    }
}