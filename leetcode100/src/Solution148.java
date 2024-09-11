import java.util.ArrayList;

import org.junit.Test;

public class Solution148 {
    @Test
    public void test(){
        ListNode148 head=new ListNode148(4);
        ListNode148 node1=new ListNode148(2);
        ListNode148 node2=new ListNode148(1);
        ListNode148 node3=new ListNode148(3);
        head.next=node1; node1.next=node2; node2.next=node3; 
        ListNode148 node=sortList(head);
        while (node!=null) {
            System.out.println(node.val);
            node=node.next;
        }
    }
    public ListNode148 sortList(ListNode148 head) {
        //逐一读取node存入arraylist，按值排序（快排），按顺序构造新链表
        ArrayList<ListNode148> alist=new ArrayList<>();
        while (head!=null) {
            alist.add(head);
            head=head.next;
        }
        fastSort(alist,0,alist.size()-1);
        for (int i = 0; i < alist.size()-1; i++) {
            alist.get(i).next=alist.get(i+1);
        }
        return alist.get(0);
    }
    private void fastSort(ArrayList<ListNode148> alist ,int left,int right) {
        //选left,(left+right)/2,right三个元素，按值排序。排好之后，选中间的元素为分割点。
        //通过交换，使得分割点左边的元素值都小于它，右边的都大于它。
        int middle=(left+right)/2;
        if(alist.get(left).val>alist.get(middle).val) swap(alist, left, middle);
        if(alist.get(middle).val>alist.get(right).val) swap(alist, right, middle);
        if(alist.get(left).val>alist.get(middle).val) swap(alist, left, middle);
        int i=left,j=right,pivot=middle;
        while (i<pivot && j>pivot) {
            while (i<pivot && alist.get(i).val<=alist.get(pivot).val) {
                i++;
            }
            while (j>pivot && alist.get(j).val>=alist.get(pivot).val) {
                j--;
            }
            if(i<pivot && j>pivot) swap(alist, i, j);
        }
        if(i>=pivot){    //分割点左边全部交换完毕，检查右边的元素：（pivot,j)
            for (int k = pivot+1; k < j; k++) {
                if(alist.get(k).val<alist.get(pivot).val) {
                    ListNode148 temp=alist.get(k);
                    for (int l = k; l >pivot; l--) {
                        alist.set(l, alist.get(l-1));
                    }
                    alist.set(pivot, temp);
                    pivot++;
                }
            }
        }
        if (j<=pivot) {     // (i,pivot)
            for (int k = i+1; k < pivot; k++) {
                if (alist.get(k).val>alist.get(pivot).val) {
                    ListNode148 temp=alist.get(k);
                    for (int l = k; l < pivot; l++) {
                        alist.set(l, alist.get(l+1));
                    }
                    alist.set(pivot, temp);
                    pivot--;
                }
            }
        }
        fastSort(alist, left, pivot);   //
        fastSort(alist, pivot+1, right);
    }
    private void swap(ArrayList<ListNode148> alist,int i,int j){
        ListNode148 node1=new ListNode148();
        node1=alist.get(i);
        alist.set(i, alist.get(j));
        alist.set(j, node1);
    }
}
/*    排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
输入：head = [4,2,1,3]
输出：[1,2,3,4]

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

输入：head = []
输出：[]
*/

