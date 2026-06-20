//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7910 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-21 17:46:07 
 */
class MedianOfTwoSortedArrays{    
    public static void main(String[] args) {
        Solution s = new MedianOfTwoSortedArrays().new Solution();

        s.findMedianSortedArrays(new int[] {1, 3}, new int[] {2});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) %2 == 0) {
            return (findMedianSortedArrays(nums1, nums2, (nums1.length + nums2.length)/2) + findMedianSortedArrays(nums1, nums2, (nums1.length + nums2.length)/2 + 1)) / 2;
        }

        return findMedianSortedArrays(nums1, nums2, (nums1.length + nums2.length)/2);
    }

    // 找到第th小的数字
    public double findMedianSortedArrays(int[] nums1, int[] nums2, int th) {
        int l1 = 0, r1 = nums1.length - 1;
        int l2 = 0, r2 = nums2.length - 1;

        int h1 = 0, h2 = 0;
        while (true) {
            h1 = (l1 + r1) / 2;
            h2 = (l2 + r2) / 2;

            if (h1 + h2 + 2 == th) {
                break;
            }
            if (h1 + h2 + 2 > th) {
                // 淘汰右边，往左边找
                if (nums1[h1] >= nums2[h2]) {
                    r1 = h1;
                } else {
                    r2 = h2;
                }
            } else {
                // 淘汰左边，往右边找
                if (nums1[h1] >= nums2[h2]) {
                    l1 = h1 + 1;
                } else {
                    l2 = h2 + 1;
                }
            }
        }

        if (h1 > nums1.length - 1 || h2 > nums2.length - 1) {
            return h1 > nums1.length - 1 ? nums2[h2] : nums1[h1];
        }

        return Math.min(nums1[h1], nums2[h2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}