package leetcode.editor.cn;

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1228 👎 0

public class P240SearchA2dMatrixIi{

    public static void main(String[] args) {
        Solution solution = new P240SearchA2dMatrixIi().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 15;
//        int[][] matrix = {{-1, 3, 5}};
//        int target = 5;
        System.out.println(solution.searchMatrix(matrix, target));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int startL = 0, startH = 0;
        int mideL = 0;
        int mideH = 0;

        if (matrix.length > 1 && matrix[0].length > 1) {
            mideL = matrix.length / 2;
            mideH = matrix[0].length / 2;
            while (!(matrix[mideL][mideH] >= target && (mideH > 0 && mideL > 0 && matrix[mideL - 1][mideH - 1] < target))) {
                if (matrix[startL][startH] > target) {
                    return false;
                } else if (matrix[startL][startH] == target) {
                    return true;
                } else {
                    if (matrix[mideL][mideH] < target) {
                        startH = mideH;
                        startL = mideL;
                        mideL = (matrix.length + mideL) / 2 == mideL ? mideL + 1 : (matrix.length + mideL) / 2;
                        mideH = (matrix[0].length + mideH) / 2 == mideH ? mideH + 1 : (matrix[0].length + mideH) / 2;
                    } else if (matrix[mideL][mideH] == target) {
                        return true;
                    } else {
                        mideL = (startL + mideL) / 2 == mideL ? mideL - 1 : (startL + mideL) / 2;
                        mideH = (startH + mideH) / 2 == mideH ? mideH - 1 : (startH + mideH) / 2;
                    }
                }
                if (mideL < 0 || mideH < 0) {
                    mideL = 0;
                    mideH = 0;
                    break;
                } else if (mideL >= matrix.length || mideH >= matrix[0].length) {
                    mideL = matrix.length - 1;
                    mideH = matrix[0].length - 1;
                    break;
                }
            }
        } else {
            mideL = matrix.length - 1;
            mideH = matrix[0].length - 1;
        }
        int t = mideL;
        int temp = 0;
        do {
            temp = mideH;
            do {
                if (matrix[t][temp] == target) {
                    return true;
                } else if (matrix[t][temp] < target) {
                    break;
                }
                temp--;
            } while (temp >= 0 && matrix[t][temp] >= target);
            t++;
        } while (t < matrix.length && matrix[t][mideH] >= target);
        t = mideH;
        do {
            temp = mideL;
            do {
                if (matrix[temp][t] == target) {
                    return true;
                } else if (matrix[temp][t] < target) {
                    break;
                }
                temp--;
            } while (temp >= 0 && matrix[temp][t] >= target);
            t++;
        } while (t < matrix[0].length && matrix[mideL][t] >= target);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 先通过二分查找找到中间节点比目标节点大，但上一个节点比目标节点小的。
 * 接下来只需要遍历这个中间节点的上面至右边，左边至下面的点（优化方向：这里可以再通过二分查找）
 * 解答成功:
 * 	执行耗时:6 ms,击败了39.03% 的Java用户
 * 	内存消耗:47.2 MB,击败了74.26% 的Java用户
 */
}