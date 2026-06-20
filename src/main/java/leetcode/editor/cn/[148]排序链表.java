//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2734 👎 0


package leetcode.editor.cn;

import utils.ListNode;

/**
 * @author  LeungHan 
 * @date    2026-03-24 23:23:50 
 */
class SortList{    
    public static void main(String[] args) {
        Solution s = new SortList().new Solution();


        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);

        head = s.sortList(head);
        System.out.println(head);
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
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        return sortList(head, null, len);
    }

    public ListNode sortList(ListNode head, ListNode tail, int len) {
        if (head == tail) {
            return head;
        }

        ListNode half = head;
        int i = 0;
        for (i = 0; i < len/2 - 1; i++) {
            half = half.next;
        }

        ListNode right = half.next;
        half.next = null;

        return mergeList( sortList(head, half, len/2), sortList(right, tail, len - len/2));
    }

    public ListNode mergeList(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        ListNode res = n1.val < n2.val ? n1 : n2;
        n1 = res == n1 ? n1.next : n1;
        n2 = res == n2 ? n2.next : n2;

        ListNode cur = res;
        while (n1 != null && n2 != null) {
            cur.next = n1.val < n2.val ? n1 : n2;
            cur = cur.next;

            n1 = cur == n1 ? n1.next : n1;
            n2 = cur == n2 ? n2.next : n2;
        }
        if (n1 != null) {
            cur.next = n1;
        }
        if (n2 != null) {
            cur.next = n2;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}