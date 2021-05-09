//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学 
// 👍 308 👎 0


package leetcode.editor.cn;
//Java：缺失数字
public class P268MissingNumber{    
    public static void main(String[] args) {      
        Solution solution = new P268MissingNumber().new Solution();       
        // TO TEST
        int[] nums = {7,6,4,2,3,5,8,0,1};
        System.out.println(solution.missingNumber(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int index = 0; // 记录哪个数缺失
        int temp;
        boolean flagFinal = false; // 判断是否是最后一个数缺失
        int p=0;
        while (index < nums.length && p < nums.length) {
            temp = nums[p];
            if (temp == nums.length) {
                flagFinal = true;
                index = p;
                p++;
            } else if (p == temp) {
                p++;
            }else {
                nums[p] = nums[temp];
                nums[temp] = temp;
            }
        }

        return flagFinal? index : nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 每个数都有自己的位置(除了最后一位数),遍历数组,将数字u归位
 *        当最后一个数存在时,index记录最后一位数的位置,及数组缺失的数字所在
 *        当最后一位数不存在时,返回数组长度
 *        解答成功:
 * 				执行耗时:1 ms,击败了53.37% 的Java用户
 * 				内存消耗:39.3 MB,击败了69.79% 的Java用户
 */
}