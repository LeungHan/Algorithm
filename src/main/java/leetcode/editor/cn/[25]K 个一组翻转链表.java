//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2820 👎 0


package leetcode.editor.cn;

import utils.ListNode;

/**
 * @author  LeungHan 
 * @date    2026-04-06 23:21:41 
 */
class ReverseNodesInKGroup{    
    public static void main(String[] args) {
        Solution s = new ReverseNodesInKGroup().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode tail = head;
        ListNode prev = res;
        while (tail != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return res.next;
                }
            }
            ListNode next = tail.next;
            reverse(head, tail);

            // 原来的head是新表的tail，新表的tail是原表的head
            head.next = next;
            prev.next = tail;

            prev = head;
            head = head.next;
            tail = head;
        }

        return res.next;
    }

    public void reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        while (head != tail) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}