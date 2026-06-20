//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2619 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  LeungHan 
 * @date    2026-03-21 01:07:17 
 */
class Subsets{    
    public static void main(String[] args) {
        Solution s = new Subsets().new Solution();

        s.subsets(new int[] {1, 2, 3});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void subsets(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 加入当前元素
        list.add(nums[index]);
        subsets(nums, index + 1, list);
        list.remove(list.size() - 1);

        // 不加入当前元素
        subsets(nums, index + 1, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}