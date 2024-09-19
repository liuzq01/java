import java.util.ArrayList;

import org.junit.Test;

public class Solution155 {
    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     //--> 返回 0.
        System.out.println(minStack.getMin());  //--> 返回 -2.
    }
    class MinStack {

        public MinStack() {
    
        }
        //用双链连接栈元素，push、pop对应链的前移、后移，tail对应top。
        //用list逐一记录每次push时的最小值，pop时删除最后一个元素，则当前最后一个元素就是当前的最小值。
        ListNode tail;
        int min;
        ArrayList<Integer> arrayList=new ArrayList<>();
        public void push(int val) {
            ListNode node=new ListNode(val);
            if (tail==null) {
                tail=node;
                min=node.val;
                arrayList.add(min);
                return;
            }
            if (node.val<min) min=node.val;
            arrayList.add(min);
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        
        public void pop() {
            arrayList.remove(arrayList.size()-1);
            ListNode temp=tail.prev;
            temp.next=null;
            tail.prev=null;
            tail=temp;
        }
        
        public int top() {
        return tail.val;
        }
        
        public int getMin() {
            return arrayList.get(arrayList.size()-1);
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x) {
            val = x;
            next = null;
            prev=null;
        }
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
/*  最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
pop、top 和 getMin 操作总是在 非空栈 上调用实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
