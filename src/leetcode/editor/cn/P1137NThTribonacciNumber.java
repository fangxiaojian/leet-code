//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 递归 
// 👍 53 👎 0


package leetcode.editor.cn;
//Java：第 N 个泰波那契数
public class P1137NThTribonacciNumber{    
    public static void main(String[] args) {      
        Solution solution = new P1137NThTribonacciNumber().new Solution();       
        // TO TEST
        System.out.println(solution.tribonacci(37));
        System.out.println(Integer.MAX_VALUE);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int a1 = 0;
        int a2 = 1;
        int a3 = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a1 + a2 + a3;
            a1 = a2;
            a2 = a3;
            a3 = result;
        }

        return result;
    }
}
//1. 暴力破解:超时
//class Solution {
//    public int tribonacci(int n) {
//        if (n == 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        } else if (n == 2) {
//            return 1;
//        } else {
//            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 暴力破解:超时
 *     运行失败:
 * 			Time Limit Exceeded
 *
 * 2. 利用3个变量存储 Tn , Tn+1 , Tn+2 ,的值
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.2 MB,击败了82.92% 的Java用户
 */
}