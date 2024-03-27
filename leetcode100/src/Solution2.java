import java.util.ArrayList;

import org.junit.Test;

public class Solution2 {        //两数相加
    @Test
    public void test(){
        //构造链表l1、l2，不断地在链表「尾部」添加新节点。链表的构造方向与遍历方向相同，可以同时进行求和、构造新链表。用while循环代替递归。
        ListNode n1=new ListNode(2,null);
        ListNode n2=new ListNode(4,null);
        ListNode n3=new ListNode(3,null);
        n1.next=n2; n2.next=n3;
        ListNode l1=n1;                     // l1=[2,4,3]  2 --> 4 --> 3 -->null
        ListNode n4=new ListNode(5,null);
        ListNode n5=new ListNode(6,null);
        ListNode n6=new ListNode(7,null);
        ListNode n7=new ListNode(8,null);
        n4.next=n5; n5.next=n6; n6.next=n7;
        ListNode l2=n4;                     // l2=[5,6,7,8]  5 --> 6 --> 7 --> 8 -->null

        ListNode l3=addTwoNumbers(l1, l2);
        //遍历打印链表
        iterateListNode(l1);
        System.out.println();
        iterateListNode(l2);
        System.out.println();
        iterateListNode(l3);
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int carry=0, remainder=0,sum=0;
        ListNode l=null,tail=null;      //l是新链，也是头节点，l.next=n1 是头节点的下一个节点。
    while (!(l1==null && l2==null )) {
            sum=l1.val+l2.val+carry;
            carry=sum/10;       //进位
            remainder=sum%10;
            if(l==null)     l=tail=new ListNode(remainder,null); //构造头节点
            else    {
                tail.next=new ListNode(remainder,null);     //构造剩余节点
                tail=tail.next; 
            } 
            l1=l1.next; l2=l2.next; 
            if(l1==null && l2!=null) l1=new ListNode(0,null);   // 两条链一长一短
            if(l2==null && l1!=null) l2=new ListNode(0,null);  
        }
        if(carry!=0)  tail.next=new ListNode(carry,null);
        return l;
    }
    @Test
    public void test1(){
        //构造链表l1、l2，不断地在链表「头部」添加新节点，链表的构造方向与遍历方向相反。
        ListNode n3=new ListNode(3,null);
        ListNode n2=new ListNode(4,n3);
        ListNode n1=new ListNode(2,n2);
        ListNode l1=n1;                     // l1=[2,4,3]  2 --> 4 --> 3 -->null
        ListNode n6=new ListNode(7,null);
        ListNode n5=new ListNode(6,n6);
        ListNode n4=new ListNode(5,n5);
        ListNode l2=n4;                     // l2=[5,6,7]  5 --> 6 --> 7 -->null

        ListNode l3=addTwoNumbers1(l1, l2);
        //遍历打印链表
        iterateListNode(l1);
        System.out.println();
        iterateListNode(l2);
        System.out.println();
        iterateListNode(l3);
    }
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int carry=0;    //进位
        sumFunction(l1,l2,carry,arrayList);
        return constructListNode(arrayList,arrayList.size()-1,null);
    }
    private void sumFunction(ListNode l1,ListNode l2, int carry, ArrayList<Integer> arrayList){     
        //求和，结果存入arrayList
        int remainder=0;
        if(l1==null && l2!=null) l1=new ListNode(0,null);
        if(l2==null && l1!=null) l2=new ListNode(0,null);    
        int sum=l1.val+l2.val+carry;
        carry=sum/10; 
        remainder=sum%10; 
        arrayList.add(remainder);
        if(l1.next==null && l2.next==null && carry!=0) arrayList.add(carry);
        if(!(l1.next==null && l2.next==null))  sumFunction(l1.next,l2.next,carry,arrayList);
    }
    private ListNode constructListNode(ArrayList<Integer> arrayList,int i,ListNode next){       //构造新链表
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
