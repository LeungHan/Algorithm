//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 11347 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-14 17:45:16 
 */
class LongestSubstringWithoutRepeatingCharacters{    
    public static void main(String[] args) {
        Solution s = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> char2Index = new HashMap<>();
        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < chars.length) {
            if (char2Index.containsKey(chars[right])) {
                left = Math.max(left, char2Index.get(chars[right]) + 1);
            }
            char2Index.put(chars[right], right);
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}