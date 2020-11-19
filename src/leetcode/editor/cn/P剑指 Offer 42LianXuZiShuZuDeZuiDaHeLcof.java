//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 160 👎 0


package leetcode.editor.cn;
//Java：连续子数组的最大和
class P剑指Offer42LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer42LianXuZiShuZuDeZuiDaHeLcof().new Solution();
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
 * 		执行耗时:1 ms,击败了99.02% 的Java用户
 * 		内存消耗:44.8 MB,击败了93.36% 的Java用户
 */
}