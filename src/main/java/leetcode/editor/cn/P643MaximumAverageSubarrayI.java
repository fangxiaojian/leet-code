//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 示例 1: 
//
// 输入: [1,12,-5,-6,50,3], k = 4
//输出: 12.75
//解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 111 👎 0


package leetcode.editor.cn;
//Java：子数组最大平均数 I
public class P643MaximumAverageSubarrayI{    
    public static void main(String[] args) {      
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();       
        // TO TEST
        int[] nums = {5};
        int k = 1;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int Max = 0;
        int temp;
        for (int i = 0; i < k; i++) {
            Max += nums[i];
        }
        temp = Max;
        for (int i = k; i < nums.length; i++) {
            temp -= nums[i - k];
            temp += nums[i];
            if (temp > Max) {
                Max = temp;
            }
        }
        return 1.0*Max/k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:2 ms,击败了100.00% 的Java用户
 * 		内存消耗:43.1 MB,击败了7.58% 的Java用户
 */
}