//给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: 5
//输出: 2
//解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
// 
//
// 示例 2: 
//
// 输入: 1
//输出: 0
//解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
// 
//
// 
//
// 注意: 
//
// 
// 给定的整数保证在 32 位带符号整数的范围内。 
// 你可以假定二进制数不包含前导零位。 
// 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同 
// 
// Related Topics 位运算 
// 👍 184 👎 0


package leetcode.editor.cn;
//Java：数字的补数
public class P476NumberComplement{    
    public static void main(String[] args) {      
        Solution solution = new P476NumberComplement().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findComplement(int num) {
        int count = 0;
        int carry = 0;      // 进位
        if (num == 0) {
            return ++count;
        }
        while (num != 0) {
            if ((num & 1) == 0) {
                count += 1 << carry;
            }
            num = num >>> 1;
            carry++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 记录当前 0 所处的位置, carry
 *       当二进制某位为0 时, 1 右移 carry 位, 加上之前的值 count
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.5 MB,击败了64.33% 的Java用户
 */
}