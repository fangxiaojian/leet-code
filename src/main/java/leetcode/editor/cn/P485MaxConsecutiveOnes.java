//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 123 👎 0


package leetcode.editor.cn;
//Java：最大连续1的个数
public class P485MaxConsecutiveOnes{    
    public static void main(String[] args) {      
        Solution solution = new P485MaxConsecutiveOnes().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int countMax = 0;
        int tempMax = 0;
        for (int num : nums) {
            if (num == 0) {
                countMax = Math.max(countMax, tempMax);
                tempMax = 0;
            } else {
                tempMax++;
            }
        }
        return Math.max(countMax, tempMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 循环遍历数组, 记录连续为1 的个数,找到最大连续为1的数量,输出
 *        解答成功:
 * 				执行耗时:2 ms,击败了94.97% 的Java用户
 * 				内存消耗:40.6 MB,击败了29.18% 的Java用户
 */
}