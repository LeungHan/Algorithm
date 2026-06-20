//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，
//返回空字符串 ""。 
//
// 测试用例保证答案唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//O(m + n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3541 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-21 00:32:46 
 */
class MinimumWindowSubstring{    
    public static void main(String[] args) {
        Solution s = new MinimumWindowSubstring().new Solution();

        s.minWindow("ADOBECODEBANC", "ABC");

        s.minWindow("a", "b");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tCh2Count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tCh2Count.put(c, tCh2Count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sCh2Count = new HashMap<>();

        int left = 0, right = 0, len = Integer.MAX_VALUE;
        int resL = -1, resR = -1;
        while (right < s.length()) {
            if (tCh2Count.containsKey(s.charAt(right))) {
                sCh2Count.put(s.charAt(right), sCh2Count.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (isEqual(tCh2Count, sCh2Count) && left <= right) {
                if (right - left + 1 < len) {
                    resL = left;
                    resR = right;
                    len = right - left + 1;
                }

                // left 退出队列
                if (tCh2Count.containsKey(s.charAt(left))) {
                    sCh2Count.put(s.charAt(left), sCh2Count.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
            right++;
        }

        if (resL == -1 || resR == -1) {
            return "";
        }

        return s.substring(resL, resR + 1);
    }

    public boolean isEqual(Map<Character, Integer> tCh2Count, Map<Character, Integer> sCh2Count) {
        Iterator iter = tCh2Count.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry)iter.next();
            Character ch = entry.getKey();
            Integer count = entry.getValue();

            if (!sCh2Count.containsKey(ch) || sCh2Count.get(ch) < count) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}