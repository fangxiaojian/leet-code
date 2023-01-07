//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 
//的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组 
// 👍 190 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：数组拆分 I
public class P561ArrayPartitionI{    
    public static void main(String[] args) {      
        Solution solution = new P561ArrayPartitionI().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            count += nums[i];
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:13 ms,击败了96.89% 的Java用户
 * 		内存消耗:40.9 MB,击败了35.72% 的Java用户
 */
}