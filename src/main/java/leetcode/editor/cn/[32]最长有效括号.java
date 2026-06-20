//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。 
//
// 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2847 👎 0


package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author  LeungHan 
 * @date    2026-03-16 00:32:49 
 */
class LongestValidParentheses{    
    public static void main(String[] args) {
        Solution s = new LongestValidParentheses().new Solution();

        System.out.println(s.longestValidParentheses("(()"));;
        System.out.println(s.longestValidParentheses("()(()"));;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }

        int lCount = s.charAt(0) == '(' ? 1 : 0;
        int res = 0;

        int[] dp = new int[s.length()]; // 以i结尾最大有效括号的长度
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lCount++;
            } else {
                if (lCount != 0) {
                    if (i - 2 >= 0 && dp[i - 1] == 0) {
                        dp[i] = dp[i - 2] + 1;
                    } else {
                        dp[i] = dp[i - 1] + 1;
                    }
                    lCount--;
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res * 2;
    }

    public int dp(String s) {
        int[][] dp = new int[s.length()][s.length()];  // dp[i][j] 表示剩余左右括号个数，左为正数，右为负数
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] =  s.charAt(i) == '(' ? 1 : -1;
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp[i].length; j++) {
                if (dp[i][j - 1]  < 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                int count = s.charAt(j) == '(' ? 1 : -1;
                dp[i][j] = dp[i][j - 1] + count;

                if (dp[i][j] == 0 && res < j -i + 1) {
                    res = j -i + 1;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}