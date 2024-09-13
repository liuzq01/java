import java.util.HashMap;

import org.junit.Test;
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    @Test
    public void test(){
    }
    //用双向链表、HashMap实现LinkedHashMap
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    HashMap<Integer,Node> hashMap=new HashMap<>();
    Node head,tail;
    public int get(int key) {  
        Node node=hashMap.get(key);
        if(node==null) return -1;
        else {
            //移到末尾
            node.prev.next=node.next;
            node.next.prev=node.prev;
            tail.next=node;
            node.prev=tail;
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if (hashMap.size()==0) {
            head=new Node(value);
            tail=head;
            hashMap.put(key, head);
        }
        if (1<=hashMap.size() && hashMap.size()<capacity ||(hashMap.size()==capacity && hashMap.get(key)!=null) ) {
            Node node=new Node(value);
            tail.next=node;
            node.prev=tail;
            tail=node;
            hashMap.put(key, node);
        }
        if (hashMap.size()==capacity && hashMap.get(key)==null) {
            //删除head对应的(key,head), head的下一个节点为新的头节点
            //hashMap.remove(key);
        }
    }
}
class Node{
    int value;
    Node prev;
    Node next;
    Node(int value){
        this.value=value;
        prev=null;
        next=null;
    }
}
/*      LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
*/
