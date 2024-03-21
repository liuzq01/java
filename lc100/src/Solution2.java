import java.util.ArrayList;

import org.junit.Test;

public class Solution2 {
    @Test
    public void test(){
        //构造链表l1、l2
        ListNode n3=new ListNode(3,null);
        ListNode n2=new ListNode(4,n3);
        ListNode n1=new ListNode(2,n2);
        ListNode l1=n1;                     // l1=[2,4,3]  2 --> 4 --> 3
        ListNode n6=new ListNode(7,null);
        ListNode n5=new ListNode(6,n6);
        ListNode n4=new ListNode(5,n5);
        ListNode l2=n4;                     // l2=[5,6,7]  5 --> 6 --> 7

        ListNode l3=addTwoNumbers(l1, l2);
        //遍历打印链表
        iterateListNode(l1);
        System.out.println();
        iterateListNode(l2);
        System.out.println();
        iterateListNode(l3);
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int carry=0;    //进位
        sumFunction(l1,l2,carry,arrayList);
        return constructListNode(arrayList,arrayList.size()-1,null);
    }
    private void sumFunction(ListNode l1,ListNode l2, int carry, ArrayList<Integer> arrayList){     
        //求和，结果存入arrayList
        int remainder=0;
        if (l1==null) l1.val=0;
        if (l2==null) l2.val=0;
        int sum=l1.val+l2.val+carry;
        carry=sum/10; 
        remainder=sum%10; 
        arrayList.add(remainder);
        if(l1.next==null && l2.next==null && carry!=0) arrayList.add(carry);
        if(!(l1.next==null && l2.next==null))  sumFunction(l1.next,l2.next,carry,arrayList);
    }
    private ListNode constructListNode(ArrayList<Integer> arrayList,int i,ListNode next){       //构造链表
        ListNode l=new ListNode(arrayList.get(i),next);
        if(i==0) return l;
        else return constructListNode(arrayList,i-1,l);
    }
    private void iterateListNode(ListNode l){       //遍历打印链表
        System.out.printf("%d ",l.val);
        if(l.next!=null) {
            iterateListNode(l.next);
        }
    }
}
