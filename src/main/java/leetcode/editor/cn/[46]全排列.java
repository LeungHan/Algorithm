//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3284 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * @author  LeungHan 
 * @date    2026-03-18 21:08:12 
 */
class Permutations{    
    public static void main(String[] args) {
        Solution s = new Permutations().new Solution();

        System.out.println(s.permute(new int[] {1, 2, 3}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indexes.add(i);
        }
        doPermute(nums, indexes, new ArrayList<>());
        return res;
    }

    public void doPermute(int[] nums, List<Integer> indexes, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            indexes.remove(i);
            list.add(nums[index]);
            doPermute(nums, indexes, list);
            list.remove(list.size() - 1);
            indexes.add(i, index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}