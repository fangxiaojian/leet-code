//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 
//
// 示例 1: 
//
// 输入: 16
//输出: true
// 
//
// 示例 2: 
//
// 输入: 5
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 位运算 
// 👍 140 👎 0


package leetcode.editor.cn;
//Java：4的幂
public class P342PowerOfFour{    
    public static void main(String[] args) {      
        Solution solution = new P342PowerOfFour().new Solution();       
        // TO TEST
        solution.isPowerOfFour(8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
// 1.
//class Solution {
//    public boolean isPowerOfFour(int num) {
//        if ((num ^ 1) == 0 || (num ^ 0x00000004) == 0) {
//            return true;
//        }
//        if ((num ^ 0x00000010) == 0 || (num ^ 0x00000040) == 0) {
//            return true;
//        }
//        if ((num ^ 0x00000100) == 0 || (num ^ 0x00000400) == 0) {
//            return true;
//        }
//        if ((num ^ 0x00001000) == 0 || (num ^ 0x00004000) == 0) {
//            return true;
//        }
//        if ((num ^ 0x00010000) == 0 || (num ^ 0x00040000) == 0) {
//            return true;
//        }
//        if ((num ^ 0x00100000) == 0 || (num ^ 0x00400000) == 0) {
//            return true;
//        }
//        if ((num ^ 0x01000000) == 0 || (num ^ 0x04000000) == 0) {
//            return true;
//        }
//        return (num ^ 0x10000000) == 0 || (num ^ 0x40000000) == 0;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.3 MB,击败了20.62% 的Java用户
 *
 * 	2. 4 的幂
 * 	    0000 0000 0000 0000 0000 0000 0000 0001    1
 * 	    0000 0000 0000 0000 0000 0000 0000 0100    4
 * 	    0000 0000 0000 0000 0000 0000 0001 0000   16
 * 	    0000 0000 0000 0000 0000 0000 0100 0000   64
 * 	    0000 0000 0000 0000 0000 0001 0000 0000  256
 * 	    0000 0000 0000 0000 0000 0100 0000 0000 1024
 * 	    0000 0000 0000 0000 0001 0000 0000 0000 4096
 *
 * 	    因此 借鉴 2的幂 的模式
 * 	    但是要排除
 * 	    0000 0000 0000 0000 0000 0000 0000 0010     2
 * 	    0000 0000 0000 0000 0000 0000 0000 1000     8
 * 	    0000 0000 0000 0000 0000 0000 0010 0000    32
 * 	    0000 0000 0000 0000 0000 0000 1000 0000   128
 * 	    等情况
 *
 * 	    num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
 * 	    0xaaaaaaaa == 1010 1010 1010 1010 1010 1010 1010 1010
 * 	解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.4 MB,击败了5.55% 的Java用户
 */
}