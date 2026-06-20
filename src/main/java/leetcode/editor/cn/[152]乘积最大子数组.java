//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 请注意，一个只包含一个元素的数组的乘积是这个元素的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2564 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-29 22:50:47 
 */
class MaximumProductSubarray{    
    public static void main(String[] args) {
        Solution s = new MaximumProductSubarray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i],min[i - 1] * nums[i]);
            max[i] = Math.max(Math.max(nums[i], max[i - 1] * nums[i]), min[i - 1] * nums[i]);

            res = Math.max(res, max[i]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}