import java.util.HashSet;

import org.junit.Test;

public class Solution141 {
    @Test
    public void test(){
        ListNode head=new ListNode(3);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(0);
        ListNode node3=new ListNode(-4);
        head.next=node1; node1.next=node2; node2.next=node3; node3.next=node1;
        /*********************************/
        ListNode head1=new ListNode(5);
        ListNode node4=new ListNode(7);
        ListNode node5=new ListNode(8);
        head1.next=node4; node4.next=node5;
        System.out.println(hasCycle(head));
        System.out.println(hasCycle(head1));
    }
    public boolean hasCycle(ListNode head) {
        //用hashSet判断是否重复
        HashSet<ListNode> hSet=new HashSet<>();
        boolean result=false;
        while (head!=null) {
            if(hSet.contains(head)) {
                result=true;
                break;
            }
            hSet.add(head);
            head=head.next;
        }
        return result;
    }
/*  环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。pos 为 -1 或者链表中的一个 有效索引 。进阶：你能用 O(1)（常量）内存解决此问题吗？
    3 -> 2 -> 0 -> -4
         |__________|
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
*/
}
