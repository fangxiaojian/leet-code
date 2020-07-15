//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1128 👎 0


package leetcode.editor.cn;
//Java：爬楼梯
public class P70ClimbingStairs{    
    public static void main(String[] args) {      
        Solution solution = new P70ClimbingStairs().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// 2. 数组
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] res = new int[n];
            res[0] = 1;
            res[1] = 1;
            for (int i = 2; i < n; i++) {
                res[i] = res[i - 1] + res[i - 2];
            }
            return res[n - 1] + res[n - 2];
        }
    }
// 1. 递归超时
//class Solution {
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 利用递归计算
 *     结果: 超时
 * 2. 用数组
 *     创建容量为n的一维数组 res
 *     res[0] = 1, res[1] = 1;
 *     res[2] = res[1] + res[0];
 *     res[3] = res[2] + res[1];
 *     ......
 *     res[n] = res[n-1] + res[n-2];
 *     返回res[n];
 *     结果:
 *     解答成功:
 * 			执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:36.4 MB,击败了5.66% 的Java用户
 */
}