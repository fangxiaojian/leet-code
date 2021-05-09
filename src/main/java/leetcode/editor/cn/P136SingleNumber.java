//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1425 👎 0


package leetcode.editor.cn;
//Java：只出现一次的数字
public class P136SingleNumber{    
    public static void main(String[] args) {      
        Solution solution = new P136SingleNumber().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length <= 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 异或运算
 *         a^a = 0
 *         a^0 = a
 *         a^b^a = a^a^b = 0^b = b
 *         题目中 各个数都出现两次, 只有一个数出现一次, 将所有数进行异或运算, 结果就是 只出现一次的数
 *
 *         解答成功:
 * 				执行耗时:1 ms,击败了99.71% 的Java用户
 * 				内存消耗:39.9 MB,击败了39.74% 的Java用户
 */
}