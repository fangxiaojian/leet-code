//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 75 👎 0


package leetcode.editor.cn;
//Java：斐波那契数列
class P剑指Offer10IFeiBoNaQiShuLieLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer10IFeiBoNaQiShuLieLcof().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int fib(int n) {
        final int e = (int) (1e9+7);
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a1 = 0;
        int a2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (a1 + a2) % e;
            a1 = a2;
            a2 = result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1.暴力破解:超时
 * 运行失败:
 * 		Time Limit Exceeded
 * 	测试用例:44
 *
 * 2. 利用两个变量存储 F(N - 1) , F(N - 2) 的值
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.2 MB,击败了85.91% 的Java用户
 *
 */
}