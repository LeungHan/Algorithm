//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2098 👎 0


package leetcode.editor.cn;

import utils.TreeNode;

/**
 * @author  LeungHan 
 * @date    2026-03-24 22:26:32 
 */
class MaximumDepthOfBinaryTree{    
    public static void main(String[] args) {
        Solution s = new MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        }

        return Math.max(maxDepth(node.left, deep + 1), maxDepth(node.right, deep + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}