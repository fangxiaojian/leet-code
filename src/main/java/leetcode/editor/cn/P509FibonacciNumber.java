//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 
// 👍 157 👎 0


package leetcode.editor.cn;
//Java：斐波那契数
public class P509FibonacciNumber{    
    public static void main(String[] args) {      
        Solution solution = new P509FibonacciNumber().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }else {
            return fibonacciNumber(N);
        }
    }

    private int fibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 递归
 *         解答成功:
 * 				执行耗时:8 ms,击败了26.71% 的Java用户
 * 				内存消耗:35.6 MB,击败了36.34% 的Java用户
 */
}