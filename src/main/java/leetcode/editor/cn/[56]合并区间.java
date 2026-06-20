//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 示例 3： 
//
// 
//输入：intervals = [[4,7],[1,4]]
//输出：[[1,7]]
//解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2747 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author  LeungHan 
 * @date    2026-03-20 00:36:18 
 */
class MergeIntervals{    
    public static void main(String[] args) {
        Solution s = new MergeIntervals().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<List<Integer>> list = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 能否和当前区间进行合并
            if (cur[1] >= intervals[i][0]) {
                cur[1] = cur[1] > intervals[i][1] ? cur[1] : intervals[i][1];
                continue;
            }

            // 如果不能合并
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            list.add(tmp);
            cur = intervals[i];
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(cur[0]);
        tmp.add(cur[1]);
        list.add(tmp);

        int[][] nums = new int[list.size()][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = list.get(i).get(0);
            nums[i][1] = list.get(i).get(1);
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}