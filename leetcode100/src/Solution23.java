import org.junit.Test;

import javax.sound.midi.Soundbank;

public class Solution23 {
    @Test
    public void test(){
        //合并 K 个升序链表
/* 
        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        输入：lists = []
        输出：[]
        输入：lists = [[]]
        输出：[] 
*/
        ListNode l1=new ListNode(1); ListNode n2=new ListNode(4);   ListNode n3=new ListNode(5);
        l1.next=n2; n2.next=n3;
        ListNode l2=new ListNode(1); ListNode n4=new ListNode(3);   ListNode n5=new ListNode(4);
        l2.next=n4; n4.next=n5;
        ListNode l3=new ListNode(2);    ListNode n6=new ListNode(6);
        l3.next=n6;
        ListNode[] lists=new ListNode[]{l1,l2,l3};
        ListNode listNode=mergeKLists(lists);
        if (listNode==null) System.out.println("空节点");
        else {
            while (listNode!=null){
                System.out.println(listNode.val);
                listNode=listNode.next;
            }
        }
   }
    public ListNode mergeKLists(ListNode[] lists) {
        //在合并 2个升序链表的基础上迭代
        if (lists==null || lists[0]==null) return null;
        Solution21 solution21=new Solution21();
        ListNode listNode=lists[0];
        for (int i = 0; i < lists.length-1; i++)
        {
            listNode=solution21.mergeTwoLists(listNode,lists[i+1]);
        }
        return listNode;
    }
}
