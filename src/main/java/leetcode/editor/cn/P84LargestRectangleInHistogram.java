package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2344 👎 0

public class P84LargestRectangleInHistogram{

    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {1, 1, 1};
        System.out.println(solution.largestRectangleArea(heights));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentH = heights[i];
            int start = i, end = i;
            do {
                start--;
            } while (start >= 0 && heights[start] >= currentH);
            do {
                if (end == i + 1 && heights[end] == currentH) {
                    i = end;
                }
                end++;
            } while (end < heights.length && heights[end] >= currentH);
            max = Math.max(max, currentH * (end - start -1));
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：计算当前节点左右两边，大于当前节点的柱的数量，即为当前节点可以用于构筑矩阵的最大面积
 * 若当前节点的高度与下一个节点的高度相同，则无需计算下一个节点，直接跳过。
 *
 * 解答成功:
 * 	执行耗时:443 ms,击败了5.51% 的Java用户
 * 	内存消耗:54.5 MB,击败了56.39% 的Java用户
 */
}