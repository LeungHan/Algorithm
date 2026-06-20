//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3231 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-17 01:21:25 
 */
class FindFirstAndLastPositionOfElementInSortedArray{    
    public static void main(String[] args) {
        Solution s = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        s.searchRange(new int[] {5,7,7,8,8,10}, 8);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        if (nums.length == 1) {
            int index = nums[0] == target ? 0: -1;
            return new int[] {index, index};
        }
        return doSearchRange(nums, target, 0, nums.length - 1);
    }

    public int[] doSearchRange(int[] nums, int target, int left, int right) {
        if (right - left < 2) {
            if (nums[left] == target) {
                if (nums[right] == target) {
                    return new int[] {left, right};
                }
                return new int[] {left, left};
            }
            if (nums[right] == target) {
                return new int[] {right, right};
            }
            return new int[] {-1, -1};
        }

        int half = (left + right) / 2;
        if (nums[half] > target) {
            // 往左边找
            return doSearchRange(nums, target, left, half - 1);
        }
        if (nums[half] < target) {
            // 往右边找
            return doSearchRange(nums, target, half + 1, right);
        }

        // 如果相同，则需要往两边找
        int[] arr1 = doSearchRange(nums, target, left, half);
        int[] arr2 = doSearchRange(nums, target, half + 1, right);

        int indexL = arr1[0] == -1 ? arr2[0] : arr1[0];
        int indexR = arr2[1] == -1 ? arr1[1] : arr2[1];

        return new int[] {indexL, indexR};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}