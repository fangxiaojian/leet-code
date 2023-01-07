//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2176 👎 0


package leetcode.editor.cn;
//Java：最大子序和
public class P53MaximumSubarray{    
    public static void main(String[] args) {      
        Solution solution = new P53MaximumSubarray().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxCount = nums[0];
            int targetMax = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    maxCount = maxCount >= targetMax ? maxCount : targetMax;
                }
                if (targetMax < 0) {
                    targetMax = nums[i];
                }else {
                    targetMax += nums[i];
                }
            }
            return maxCount >= targetMax ? maxCount : targetMax;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：
 * 1. 定义最大值与临时值为数组第一个数, 从第二个数开始遍历数组, 若遇到数组的值<0, 则比较临时值与最大值, 重新定义最大值,
 *     同时临时值>0 +数组值, <0 等于数字值
 *     结果：
 *     解答成功:
 * 			执行耗时:1 ms,击败了95.16% 的Java用户
 * 			内存消耗:39.8 MB,击败了38.20% 的Java用户
 */
}