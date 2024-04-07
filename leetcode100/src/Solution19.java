import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class Solution19 {
    @Test
    //删除链表的倒数第 N 个结点
    /* 
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        输入：head = [1], n = 1
        输出：[]
    */
    public void test(){
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        head.next=node2; node2.next=node3; node3.next=node4; node4.next=node5;
        ListNode h=removeNthFromEnd(head, 2);
        while (h!=null) {
            System.out.println(h.val);
            h=h.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //遍历单链表，存入list，再删除节点
        List<ListNode> list= new ArrayList<>();
        while (head.next!=null){
            list.add(head);
            head=head.next;
        }
        ListNode frontNode=list.get(list.size()-n);     //待删除节点的前一个节点(待改进：删除的是头节点)
        frontNode.next=frontNode.next.next;
        return list.get(0);
    }

}
