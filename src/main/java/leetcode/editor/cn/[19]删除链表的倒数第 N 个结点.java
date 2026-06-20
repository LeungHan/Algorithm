//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 3278 👎 0


package leetcode.editor.cn;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-14 19:24:54 
 */
class RemoveNthNodeFromEndOfList{    
    public static void main(String[] args) {
        Solution s = new RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        Map<Integer, ListNode> index2Node = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            index2Node.put(index, cur);
            index++;
            cur = cur.next;
        }
        index--;
        if (n == index + 1) {
            return head.next;
        }

        int deleteIndex = index - n + 1;
        ListNode pre = index2Node.get(deleteIndex - 1);
        ListNode next = index2Node.get(deleteIndex + 1);
        pre.next = next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}