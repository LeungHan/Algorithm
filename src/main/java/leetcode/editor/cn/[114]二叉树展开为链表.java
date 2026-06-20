//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1990 👎 0


package leetcode.editor.cn;

import utils.TreeNode;

/**
 * @author  LeungHan 
 * @date    2026-03-28 22:42:34 
 */
class FlattenBinaryTreeToLinkedList{    
    public static void main(String[] args) {
        Solution s = new FlattenBinaryTreeToLinkedList().new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        s.flatten(root);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        doFlatten(root);
    }

    public TreeNode doFlatten(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode lHead = node.left;
        TreeNode rHead = node.right;
        node.left = null;
        node.right = null;

        TreeNode lTail = doFlatten(lHead);
        TreeNode rTail = doFlatten(rHead);

        if (lTail == null && rTail == null) {
            return node;
        }

        if (lTail == null) {
            node.right = rHead;
            return rTail;
        }

        if (rTail == null) {
            node.right = lHead;
            return lTail;
        }

        node.right = lHead;
        lTail.right = rHead;
        return rTail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}