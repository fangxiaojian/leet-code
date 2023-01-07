//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


package leetcode.editor.cn;
//Java：盛最多水的容器
public class P11ContainerWithMostWater{    
    public static void main(String[] args) {      
        Solution solution = new P11ContainerWithMostWater().new Solution();       
        // TO TEST
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxArea(int[] height) {
        // 判断数组是否为null
        if (height == null || height.length == 0) {
            return 0;
        }
        // 记录最大值
        int max = 0;
        // 左右双指针
        int left = 0;
        int right = height.length - 1;
        // 遍历数组
        for (int i = 0; i < height.length && right > left; i++) {
            // 判断那边比较小, 小的往中间靠拢
            if (height[left] >= height[right]) {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            } else {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 利用双指针, 从左右两边向中间遍历, 比较两边大小, 小的那边向中间靠拢
 *     解答成功:
 * 			执行耗时:3 ms,击败了92.55% 的Java用户
 * 			内存消耗:40.1 MB,击败了60.78% 的Java用户
 */
}