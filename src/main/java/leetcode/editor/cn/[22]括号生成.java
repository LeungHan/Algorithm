//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 4037 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author  LeungHan 
 * @date    2026-03-14 19:58:18 
 */
class GenerateParentheses{    
    public static void main(String[] args) {
        Solution s = new GenerateParentheses().new Solution();

        s.generateParenthesis(3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(new StringBuffer(), 0, 0, n);
        return res;
    }

    public void dfs(StringBuffer buffer, int lCount, int rCount, int n) {
        if (rCount >= n) {
            res.add(buffer.toString());
            return;
        }
        if (lCount < n) {
            // 可以继续添加左括号
            buffer.append('(');
            int length = buffer.length();
            dfs(buffer, lCount + 1, rCount, n);
            buffer.deleteCharAt(length - 1);
        }

        if (lCount > rCount) {
            // 可以继续添加右括号
            buffer.append(')');
            int length = buffer.length();
            dfs(buffer, lCount, rCount + 1, n);
            buffer.deleteCharAt(length - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}