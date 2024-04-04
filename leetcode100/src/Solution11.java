import org.junit.Test;

public class Solution11 {
    //盛最多水的容器
    @Test
    public void test(){
        int[] height={1,8,6,2,5,4,8,3,7}; //max=49
        System.out.println(maxArea(height));
    }
    public int maxArea(int[] height) {
        //设left、right分别为水池的左右边界，从左到右移动left。对于每一个left，移动right并计算最大值
        int left=0,right=0,max=0,area=0;
        for (left = 0; left <= height.length-2; left++) {
            for ( right = left+1; right <= height.length-1; right++) {
                area=(right-left)*Math.min(height[left], height[right]);    //计算一个水池的面积
                if(area>max) max=area;
            }
        }
        return max;
    }
}
