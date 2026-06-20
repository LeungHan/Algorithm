//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2821 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author  LeungHan 
 * @date    2026-03-29 00:05:07 
 */
class LongestConsecutiveSequence{    
    public static void main(String[] args) {
        Solution s = new LongestConsecutiveSequence().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 1;
        for (Integer integer : numSet) {
            if (numSet.contains(integer - 1)) {
                // 从之前的元素开始查找
                continue;
            }

            int curLen = 1, curNum = integer;
            while (numSet.contains(curNum + 1)) {
                curLen++;
                curNum++;
            }

            res = Math.max(res, curLen);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}