//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


package leetcode.editor.cn;
//Java：回文数
public class P9PalindromeNumber{    
    public static void main(String[] args) {      
        Solution solution = new P9PalindromeNumber().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            if (result == 0) { // 防止末尾为 0 的数出现
                return false;
            }
            if (x == result) { // 个数为奇数的数
                return true;
            }
            x /= 10;
        }
        return x == result ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：
 * 1. 暴力手段：将末尾的数组成新数 与 原数前边的数进行比较
 *     1).小于0的数---不是
 *     2).10倍数的数---不是
 *     3).个数为奇数的数---需在中途判断
 *     4).个数为偶数的数---在最后进行判断
 *
 *     解答成功:
 * 			执行耗时:9 ms,击败了98.96% 的Java用户
 * 			内存消耗:39.1 MB,击败了5.14% 的Java用户
 */
}