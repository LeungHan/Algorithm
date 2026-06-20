//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 6175 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author  LeungHan 
 * @date    2026-03-18 00:21:35 
 */
class TrappingRainWater{    
    public static void main(String[] args) {
        Solution s = new TrappingRainWater().new Solution();


        System.out.println(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));;
        System.out.println(s.trap(new int[] {0,7,1,4,6}));;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        return stack(height);
    }

    public int stack(int[] height) {
        int res = 0;
        Stack<Integer> stack =  new Stack<>();      // 存储下标
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int lIndex = stack.peek(); // 像前找一个作为左边界
                int curW = i - lIndex - 1;
                int curH = Math.min(height[lIndex], height[i]) - height[cur];
                res += curH * curW;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}