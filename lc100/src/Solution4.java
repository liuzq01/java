import java.util.ArrayList;

import org.junit.Test;

public class Solution4 {
    //寻找两个正序数组的中位数
    @Test
    public void test(){
        int[] nums1={1,2,2,3,3,4,8,16,32,64};
        int[] nums2 ={5,7,30,32,65};//7.5
        //int[] nums2 ={5,7,32,32,65};//7
        System.out.println(findMedianSortedArrays(nums1, nums2));
           }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //按正序合并俩数组，存入arrayList，并去重。 时间：O（m+n)，空间：O(m+n)
        ArrayList<Integer> arrayList=new ArrayList<>();
        int i=0,j=0;
        while (i<nums1.length || j<nums2.length) {
            while (i<nums1.length && j<nums2.length) {
                if(nums1[i]<nums2[j]) {     //把小的存入arrayList，去重
                    if(!arrayList.contains(nums1[i])) arrayList.add(nums1[i]);
                    i++;
                }
                else break;
            }
            while (i<nums1.length && j<nums2.length) {
                if(nums1[i]>=nums2[j]) {
                    if(!arrayList.contains(nums2[j])) arrayList.add(nums2[j]);
                    j++;
                }
                else break;
            }
            if(i==nums1.length) {       //一个数组遍历完了，把另一个数组剩余的都存入arrayList
                if(j==nums2.length) break;
                arrayList.add(nums2[j]);
                j++;
            }
            if(j==nums2.length) {
                if(i==nums1.length) break;
                arrayList.add(nums1[i]);
                i++;
            }
        }
        for (int j2 = 0; j2 < arrayList.size(); j2++) {
            System.out.printf("%d ",arrayList.get(j2));
        }
        System.out.println();
        if(arrayList.size()%2==1) return arrayList.get(arrayList.size()/2);     //输出中位数
        else {
            int m=arrayList.size()/2;
            return (arrayList.get(m-1)+arrayList.get(m))/2.0;
        }
    }
}
