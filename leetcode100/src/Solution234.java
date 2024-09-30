import org.junit.Test;

public class Solution234 {
    @Test
    public void test(){
        ListNode head=new ListNode(1); head.next=new ListNode(2); head.next.next=new ListNode(2);head.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head));

        ListNode head1=new ListNode(1); head1.next=new ListNode(2); head1.next.next=new ListNode(4);head1.next.next.next=new ListNode(2);head1.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head1));

        ListNode head2=new ListNode(1); head2.next=new ListNode(2); head2.next.next=new ListNode(3);head2.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head2));
        
        ListNode head3=new ListNode(1); head3.next=new ListNode(2); 
        System.out.println(isPalindrome(head3));
  }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        // 从中间位置断开单链表，反转其中一半，对比
        ListNode fast=head, slow=head;
        while (fast!=null) {
            fast=fast.next;
            if(fast!=null && fast.next!=null)  fast=fast.next;
            else break;
            slow=slow.next;
        }
        ListNode head1=slow.next;
        slow.next=null;
        // 如果反转前半段链表，节点个数为奇数时，下面的逻辑不成立，所以反转后半段链表。
        ListNode n1=null, n2=head1, n3=head1.next;
        while (n3!=null) {
            n2.next=n1; n1=n2; n2=n3; n3=n3.next;
        }
        // 对比
        head1=n2;
        while (head!=null && head1!=null) {
            if(head.val!=head1.val) return false;
            head=head.next;
            head1=head1.next;
        }
        return true; 
    }
}
/*      回文链表
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
输入：head = [1,2,2,1]
输出：true

输入：head = [1,2]
输出：false
 */

