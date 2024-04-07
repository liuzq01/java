import org.junit.Test;

public class Solution21 {
    @Test
    //合并两个有序链表
    /*
        输入：l1 = [1,2,4], l2 = [1,3,4,5]
        输出：[1,1,2,3,4,4,5,6]
        输入：l1 = [], l2 = [2,4]
        输出：[2,4]
        输入：l1 = [], l2 = []     //l1==null与l1是空链有什么区别？
        输出：[]
        l1 和 l2 均按升序排列
    */
    public void test(){
        /* */
        ListNode l1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(4);
        l1.next=n2; n2.next=n3;
        ListNode l2=new ListNode(1);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);
        l2.next=n4; n4.next=n5; n5.next=n6;
        /*         */
        /*
        ListNode l1=null;
        ListNode l2=new ListNode(2);
        ListNode n3=new ListNode(4);
        l2.next=n3;
             */
        /*
        ListNode l1=null;
        ListNode l2=null;
        */
        ListNode l3=mergeTwoLists(l1, l2);
        if(l3==null)  System.out.println("空节点");
        while (l3!=null) {
            System.out.println(l3.val);
            l3=l3.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //设合并后的新链为h，比较l1、l2上节点的值。值小的节点，复制给新链，双双移动到下一个节点，直到一个链上的节点被复制完。
        if (list1==null)  return list2;
        if (list2==null)  return list1;
        ListNode head=new ListNode();
        if (list1.val<=list2.val) {     //初始化新链的头节点
            head.val=list1.val;
            list1=list1.next;
        }
        else {
            head.val=list2.val;
            list2=list2.next;
        }
        ListNode tail=head;     //tail是新链的尾节点
        while (list1!=null && list2!=null) {
            if (list1.val<=list2.val) {
                tail.next=list1;
                tail=tail.next;
                list1=list1.next;
            }
            else {
                tail.next=list2;
                tail=tail.next;
                list2=list2.next;
            }
            if (list1==null) tail.next=list2;   //其中一条链的数据复制完毕
            if (list2==null) tail.next=list1;
        }
        return head;
    }
}
