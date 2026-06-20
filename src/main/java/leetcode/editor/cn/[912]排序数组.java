//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//解释：请注意，nums 的值不一定唯一。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 1218 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-29 22:07:39 
 */
class SortAnArray{    
    public static void main(String[] args) {
        Solution s = new SortAnArray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);

        return nums;
    }

    public void sortArray(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int half = (left + right) / 2;
        sortArray(nums, left, half);
        sortArray(nums, half + 1, right);

        mergeArray(nums, left, right, half);
    }

    public void mergeArray(int[] nums, int left, int right, int half){
        int p1 = left, p2 = half + 1;
        int[] help = new int[right - left + 1];
        int index = 0;
        while (p1 <= half && p2 <= right) {
            help[index++] = nums[p1] < nums[p2] ? nums[p1++]:nums[p2++];
        }

        while (p1 <= half) {
            help[index++] = nums[p1++];
        }

        while (p2 <= right) {
            help[index++] = nums[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}