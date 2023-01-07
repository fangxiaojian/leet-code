//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 498 👎 0


package leetcode.editor.cn;
//Java：加一
public class P66PlusOne{    
    public static void main(String[] args) {      
        Solution solution = new P66PlusOne().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits[digits.length - 1] + 1 <= 9) {
                digits[digits.length - 1]++;
                return digits;
            }
            int temp = 1;
            int ws = 0;
            int[] result = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 0; i--) {
                ws = digits[i] + temp;
                digits[i] = ws % 10;
                result[i + 1] = ws % 10;
                temp = ws / 10;
                if (temp == 0) {
                    return digits;
                }
            }
            result[0] = temp;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 若原数组+1后最高位需要进1, 则返回新数组, 若不用, 则返回原数组
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:38.1 MB,击败了5.63% 的Java用户
 */
}