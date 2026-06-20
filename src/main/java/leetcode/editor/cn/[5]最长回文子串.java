//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 8014 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-14 18:00:03 
 */
class LongestPalindromicSubstring{    
    public static void main(String[] args) {
        Solution s = new LongestPalindromicSubstring().new Solution();

        s.longestPalindrome("cbbd");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int count = 0, offset = 0;

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    continue;
                }
                dp[i][j] = j - i < 2 || dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > count) {
                    count = j - i + 1;
                    offset = i;
                }
            }
        }

        return new String(chars, offset, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}