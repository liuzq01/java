import java.util.Arrays;

import org.junit.Test;

public class Solution739 {
    @Test
    public void test(){
        //int[] temperatures={73,74,75,71,69,72,76,73};
        int[] temperatures={30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out=new int[temperatures.length];
        for (int i = 0; i < temperatures.length-1; i++) {
            int count=0;
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j]>temperatures[i]) {
                    out[i]=count+1;
                    break;
                }
                count++;
                if (j==temperatures.length-1) {
                    out[i]=0;
                }
            }
        }
        out[temperatures.length-1]=0;
        return out;
    }
}
/*
 * 739. 每日温度
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]
 */

