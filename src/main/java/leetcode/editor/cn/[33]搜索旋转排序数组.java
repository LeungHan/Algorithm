//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], 
//nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1
//,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 3348 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-17 00:59:36 
 */
class SearchInRotatedSortedArray{    
    public static void main(String[] args) {
        Solution s = new SearchInRotatedSortedArray().new Solution();

        s.search(new int[]{1, 3}, 0);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length-1);
    }

    public int doSearch(int[] nums, int target, int left, int right) {
        if (right - left <= 1) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }
        
        int half = (left + right) / 2;
        if (target == nums[half]) {
            return half;
        }
        if (nums[half] < nums[right]) {
            // 右边升序
            if (target > nums[half] && target <= nums[right]) {
                // 在右边
                return doSearch(nums, target, half + 1, right);
            } else {
                // 在左边
                return doSearch(nums, target, left, half - 1);
            }
        } else {
            // 左边升序
            if (target >= nums[left] && target < nums[half]) {
                // 在左边
                return doSearch(nums, target, left, half - 1);
            } else {
                // 在右边
                return doSearch(nums, target, half + 1, right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}