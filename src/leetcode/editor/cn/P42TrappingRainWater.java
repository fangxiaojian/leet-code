//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2306 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class P42TrappingRainWater{    
    public static void main(String[] args) {      
        Solution solution = new P42TrappingRainWater().new Solution();       
        // TO TEST
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        solution.trap(height);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int max = 0;
        int first = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0 && stack.isEmpty()) {
                continue;
            } else if (height[i] != 0 && stack.isEmpty()) {
                first = height[i];
                max = first;
            } else if (!stack.isEmpty() && max <= height[i]) {
                stack.push(height[i]);
                sum += TrapRainWater(stack, first);
                stack.empty();
                max = height[i];
                first = height[i];
            }
            stack.push(height[i]);
        }
        if (!stack.isEmpty()) {
            max = stack.pop();
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if (temp >= max) {
                    max = temp;
                } else {
                    sum += max - temp;
                }
            }
        }
        return sum;
    }
    private int TrapRainWater(Stack<Integer> stack, int left) {
        int sum = 0;
        int right = stack.pop();
        int temp = 0;
        int min = left >= right ? right : left;
        if (!stack.isEmpty()) {
            sum += min * (stack.size()-1);
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp < min) {
                sum -= temp;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:3 ms,击败了30.72% 的Java用户
 * 		内存消耗:38.2 MB,击败了27.44% 的Java用户
 */
}