//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 严格小于 当前节点的数。 
// 节点的右子树只包含 严格大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2739 👎 0


package leetcode.editor.cn;

import utils.TreeNode;

/**
 * @author  LeungHan 
 * @date    2026-03-21 17:07:56 
 */
class ValidateBinarySearchTree{    
    public static void main(String[] args) {
        Solution s = new ValidateBinarySearchTree().new Solution();

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        s.isValidBST(root);
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
    class IsValidBST {
        boolean isValidBST;
        int min, max;
        IsValidBST(boolean isValidBST) {
            this.isValidBST = isValidBST;
        }
        IsValidBST(boolean isValidBST, int min, int max) {
            this.isValidBST = isValidBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        IsValidBST rsValidBST = doIsValidBST(root);
//        return rsValidBST.isValidBST;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public IsValidBST doIsValidBST(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new IsValidBST(true, node.val, node.val);
        }

        if (node.left == null) {
            IsValidBST rIsValidBST = doIsValidBST(node.right);
            if (rIsValidBST.isValidBST && rIsValidBST.min > node.val) {
                return new IsValidBST(true, node.val, rIsValidBST.max);
            }
            return new IsValidBST(false);
        }

        if (node.right == null) {
            IsValidBST lIsValidBST = doIsValidBST(node.left);
            if (lIsValidBST.isValidBST && lIsValidBST.max < node.val) {
                return new IsValidBST(true, lIsValidBST.min, node.val);
            }
            return new IsValidBST(false);
        }


        IsValidBST lIsValidBST = doIsValidBST(node.left);
        IsValidBST rIsValidBST = doIsValidBST(node.right);

        if (lIsValidBST.isValidBST && rIsValidBST.isValidBST) {
            int lMax = lIsValidBST.max;
            int rMin = rIsValidBST.min;

            if (lMax < node.val && rMin > node.val) {
                return new IsValidBST(true, lIsValidBST.min, rIsValidBST.max);
            }
            return new IsValidBST(false);
        }

        return new IsValidBST(false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}