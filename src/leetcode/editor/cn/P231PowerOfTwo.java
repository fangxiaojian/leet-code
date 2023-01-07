//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 2^0 = 1
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 2^4 = 16
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 247 👎 0


package leetcode.editor.cn;
//Java：2的幂
public class P231PowerOfTwo{    
    public static void main(String[] args) {      
        Solution solution = new P231PowerOfTwo().new Solution();       
        // TO TEST
        System.out.println(solution.isPowerOfTwo(0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isPowerOfTwo(int n) {
    return n>0 && (n&(n-1)) == 0;
    }
}
// 1.
//class Solution {
//    public boolean isPowerOfTwo(int n) {
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                n = n >> 1;
//                if (n != 0) {
//                    return false;
//                }else {
//                    return true;
//                }
//            }
//            n = n >> 1;
//        }
//        return false;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 对于负数, 10000000000000000000000000000000
 * 不是 2 的幂
 * 解答成功:
 * 		执行耗时:2 ms,击败了8.27% 的Java用户
 * 		内存消耗:36 MB,击败了72.56% 的Java用户
 *
 * 	2. n>0 && (n&(n-1)) == 0;
 * 	   2 的幂 一定大于0,
 * 	   2 的幂 二进制为 1 0000  的形式, 即一个1 后面带 x 个0
 * 	      若 n 为 2 的幂 那么 n-1 为 1111...  即前面都为0, 后面带 x 个1
 * 	      n & (n-1) 若 n 二进制不止一个1, 则返回 false
 * 	      否则  返回 true
 * 	解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:36 MB,击败了68.06% 的Java用户
 */
}