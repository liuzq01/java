import java.util.ArrayList;

import org.junit.Test;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution206 {
    @Test
    public void test(){
        ListNode head=new ListNode(1);ListNode node1=new ListNode(2);ListNode node2=new ListNode(3);ListNode node3=new ListNode(4);ListNode node4=new ListNode(5);
        head.next=node1; node1.next=node2; node2.next=node3; node3.next=node4;
        head=reverseList(head);
        while (head!=null) {
            System.out.printf(head.val+"  ");
            head=head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode node1=head.next,node2=node1.next;
        if (node2==null) {
            node1.next=head;
            head.next=null;
            return node1;
        }
        ArrayList<ListNode> list=new ArrayList<>();
        reverseList(head,node1,node2,list,0);
        return list.get(0);
    }
    private void reverseList(ListNode head, ListNode node1, ListNode node2,ArrayList<ListNode> list,int i) {
        node1.next=head;
        if (i==0) {
            head.next=null;
            i++;
        }
        if(node2==null) {
            list.add(node1);
            return;
        }
        reverseList(node1,node2,node2.next,list,i);
    }
}
/*     反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

输入：head = [1,2]
输出：[2,1]

输入：head = []
输出：[]
*/

