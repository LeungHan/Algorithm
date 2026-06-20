//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 3208 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-14 18:50:16 
 */
class LetterCombinationsOfAPhoneNumber{    
    public static void main(String[] args) {
        Solution s = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(s.letterCombinations("23"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character, String> num2String;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        num2String = new HashMap(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        dfs(digits.toCharArray(), 0, new StringBuffer());
        return res;
    }

    public void dfs(char[] chars, int index, StringBuffer buffer) {
        if (index == chars.length) {
            res.add(buffer.toString());
            return;
        }

        char[] prefixes = num2String.get(chars[index]).toCharArray();
        for (char prefix : prefixes) {
            buffer.append(prefix);
            dfs(chars, index + 1, buffer);
            buffer.deleteCharAt(index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}