//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2397 👎 0


package leetcode.editor.cn;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  LeungHan 
 * @date    2026-03-21 16:58:48 
 */
class BinaryTreeInorderTraversal{    
    public static void main(String[] args) {
        Solution s = new BinaryTreeInorderTraversal().new Solution();
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
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        doInorderTraversal(root);
        return res;
    }

    public void doInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        doInorderTraversal(node.left);
        res.add(node.val);
        doInorderTraversal(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}