//
// 给你一个输入字符串 (
// s) 和一个字符模式 (
// p) ，请你实现一个支持 
// '?' 和 
// '*' 匹配规则的通配符匹配：
// 
//
// 
// '?' 可以匹配任何单个字符。 
// '*' 可以匹配任意字符序列（包括空字符序列）。 
// 
//
// 
// 
// 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "aa", p = "*"
//输出：true
//解释：'*' 可以匹配任意字符串。
// 
//
// 示例 3： 
//
// 
//输入：s = "cb", p = "?a"
//输出：false
//解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, p.length <= 2000 
// s 仅由小写英文字母组成 
// p 仅由小写英文字母、'?' 或 '*' 组成 
// 
//
// Related Topics 贪心 递归 字符串 动态规划 👍 1255 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-19 00:37:56 
 */
class WildcardMatching{    
    public static void main(String[] args) {
        Solution s = new WildcardMatching().new Solution();

        System.out.println(s.isMatch("", "****"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }

        if (sIndex == s.length() && p.charAt(pIndex) == '*') {
            return isMatch(s, p, sIndex, pIndex + 1);
        }

        if (sIndex == s.length() || pIndex == p.length()) {
            return false;
        }

        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
            return isMatch(s, p, sIndex + 1, pIndex + 1);
        }

        if (p.charAt(pIndex) != '*') {
            return false;
        }

        if (pIndex == p.length() - 1) {
            return true;
        }

        while (sIndex < s.length()) {
            if (isMatch(s, p, sIndex, pIndex + 1)){
                return true;
            }
            sIndex++;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}