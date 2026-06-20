//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3764 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-24 22:38:16 
 */
class LruCache{    
    public static void main(String[] args) {
        LRUCache s = new LruCache().new LRUCache(2);

        s.put(1, 1);
        s.put(2, 2);
        System.out.println(s.get(1));
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4, 4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private class DQueueNode {
        int key;
        int value;
        DQueueNode next;
        DQueueNode prev;

        public DQueueNode() {}

        public DQueueNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DQueueNode> map;
    private DQueueNode tail;
    private DQueueNode head;
    private int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;

        this.tail = new DQueueNode();
        this.head = new DQueueNode();
        this.tail.prev = this.head;
        this.head.next = this.tail;
    }
    
    public int get(int key) {
        // write code here
        if (!this.map.containsKey(key)) {
            return -1;
        }

        DQueueNode node = map.get(key);
        removeNode(node);
        addTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // write code here
        if (map.containsKey(key)) {
            DQueueNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addTail(node);
            this.map.put(key, node);
            return;
        }

        if (this.capacity == this.map.size()) {
            DQueueNode node = removeHead();
            this.map.remove(node.key);
        }

        DQueueNode node = new DQueueNode(key, value);
        addTail(node);
        this.map.put(key, node);
    }

    private void addTail(DQueueNode node){
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }

    private DQueueNode removeHead(){
        DQueueNode node = head.next;
        DQueueNode next = head.next.next;
        this.head.next = next;
        next.prev = this.head;

        return node;
    }

    private void removeNode(DQueueNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
        
}