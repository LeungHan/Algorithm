//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 2217 👎 0


package leetcode.editor.cn;
/** 
 * @author  LeungHan 
 * @date    2026-03-18 21:28:01 
 */
class RotateImage{    
    public static void main(String[] args) {
        Solution s = new RotateImage().new Solution();

        int[][] data = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        s.rotate(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (j != data[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        while (bottom - top >= 1) {
            for (int cur = 0; cur < bottom - top; cur++) {
                int tmp = matrix[top][top + cur];
                matrix[top][top + cur] = matrix[bottom - cur][top];
                matrix[bottom - cur][top] = matrix[bottom][bottom - cur];
                matrix[bottom][bottom - cur] = matrix[top + cur][bottom];
                matrix[top + cur][bottom] = tmp;
            }

            top++;
            bottom--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
        
}