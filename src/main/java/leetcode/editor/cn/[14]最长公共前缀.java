//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics 字典树 数组 字符串 👍 3476 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author  LeungHan 
 * @date    2026-03-18 22:13:35 
 */
class LongestCommonPrefix{    
    public static void main(String[] args) {
        Solution s = new LongestCommonPrefix().new Solution();

        System.out.println(s.longestCommonPrefix(new String[] {"flower","flow","flight"}));;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int j;
            for (j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) != cur.charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}