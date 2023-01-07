//给定一个整数数组，找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 55 👎 0


package leetcode.editor.cn;
//Java：连续数列
class P面试题1617ContiguousSequenceLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1617ContiguousSequenceLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxSubArray(int[] nums) {
        int maxCount = nums[0];
        int targetMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxCount = Math.max(maxCount, targetMax);
            }
            if (targetMax < 0) {
                targetMax = nums[i];
            }else {
                targetMax += nums[i];
            }
        }
        return Math.max(maxCount, targetMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了94.77% 的Java用户
 * 		内存消耗:38.3 MB,击败了86.83% 的Java用户
 */
}