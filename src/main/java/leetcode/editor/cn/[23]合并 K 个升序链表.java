//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 3178 👎 0


package leetcode.editor.cn;

import utils.ListNode;

/**
 * @author  LeungHan 
 * @date    2026-03-15 03:23:54 
 */
class MergeKSortedLists{    
    public static void main(String[] args) {
        Solution s = new MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return doMergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode doMergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int half = (left + right) / 2;
        ListNode l1 = doMergeKLists(lists, left, half);
        ListNode l2 = doMergeKLists(lists, half + 1, right);

        return doMerge2Lists(l1, l2);
    }

    public ListNode doMerge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = l1.val < l2.val ? l1 : l2;
        l1 = head == l1 ? l1.next : l1;
        l2 = head == l2 ? l2.next : l2;

        ListNode cur = head;
        while (l1 != null && l2 != null) {
            cur.next = l1.val < l2.val ? l1 : l2;

            cur = cur.next;
            l1 = cur == l1 ? l1.next : l1;
            l2 = cur == l2 ? l2.next : l2;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null ){
            cur.next = l2;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}