//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// "1" -> 'A' "2" -> 'B' ... "25" -> 'Y' "26" -> 'Z' 
//
// 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。 
//
// 例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1, 1, 10, 6) 
// "KJF" ，将消息分组为 (11, 10, 6) 
// 消息不能分组为 (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。 
// 
//
// 注意，可能存在无法解码的字符串。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics 字符串 动态规划 👍 1648 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-21 16:19:13 
 */
class DecodeWays{    
    public static void main(String[] args) {
        Solution s = new DecodeWays().new Solution();

        System.out.println(s.numDecodings("10011")); //0
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res;
    public int numDecodings(String s) {
        if (s == "" || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int num = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (s.charAt(i) == '0' && (num > 26 || num <= 0)) {
                // 无法和前一个组合
                continue;
            }
            if (s.charAt(i) == '0') {
                dp[i] = i == 1 ? 1 : dp[i - 2];
                continue;
            }

            // 不为0的情况
            dp[i] = dp[i - 1];
            if (s.charAt(i - 1) != '0' && num <= 26) {
                dp[i] = i == 1?dp[i] + 1 : dp[i] + dp[i - 2];
            }

        }
        return dp[dp.length - 1];
    }

    public void numDecodings(String s, int index) {
        if (index == s.length()) {
            res++;
            return;
        }
        if (s.charAt(index) == '0') {
            return;
        }

        numDecodings(s, index + 1);
        if (index < s.length() - 1) {
            int num = (s.charAt(index) - '0') * 10 + s.charAt(index + 1) - '0';
            if (num <= 26) {
                numDecodings(s, index + 2);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}