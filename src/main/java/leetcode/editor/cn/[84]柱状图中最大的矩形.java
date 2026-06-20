//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 3104 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * @author  LeungHan 
 * @date    2026-03-21 14:47:56 
 */
class LargestRectangleInHistogram{    
    public static void main(String[] args) {
        Solution s = new LargestRectangleInHistogram().new Solution();

        s.largestRectangleArea(new int[] {2, 1, 2});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int[] extHeight = new int[heights.length + 2];
        for(int i = 1; i < extHeight.length - 1; i++) {
            extHeight[i] = heights[i - 1];
        }


        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < extHeight.length; i++) {
            if (stack.isEmpty() || extHeight[i] >= extHeight[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && extHeight[stack.peek()] > extHeight[i]) {
                int left = stack.pop();
                res = Math.max(res,  extHeight[left] * (i - left));
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}