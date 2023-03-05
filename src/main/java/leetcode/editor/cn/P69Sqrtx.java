//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 442 👎 0


package leetcode.editor.cn;
//Java：x 的平方根
public class P69Sqrtx{    
    public static void main(String[] args) {      
        Solution solution = new P69Sqrtx().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x <= 1) {
                return x;
            }
            double y;
            double s = x/2;
            y = (s + x / s) / 2;
            while (y != s) {
                s = y;
                y = (s + x / s) / 2;
            }
            return (int)y;
        }
    }
// 1.
//class Solution {
//    public int mySqrt(int x) {
//        if (x <= 1) {
//            return x;
//        }
//        int left = x/2;
//        int right = x;
//        int temp = left * left;
//        while (temp > x || temp < 0 || left > 46340) {
//            right = left;
//            left /= 2;
//            temp = left * left;
//        }
//        for (int mid = (left + right) / 2; left <= right; ) {
//            temp = mid * mid;
//            if (temp <= x && temp>0) {
//                temp = (mid+1)*(mid+1);
//                if (temp > x || temp < 0) {
//                    return mid;
//                } else {
//                    left = mid;
//                }
//            }else {
//                right = mid;
//            }
//            mid = (left + right) / 2;
//        }
//        return 0;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 通过x/2 来计算其平方根的范围, 需要注意的是Integer.MAX_VALUE= 2147483647
 *     通过平方来比较时会溢出
 *     结果:
 *     解答成功:
 * 			执行耗时:2 ms,击败了57.81% 的Java用户
 * 			内存消耗:36.9 MB,击败了5.55% 的Java用户
 * 2. 牛顿迭代法 y = (x + a/x) / 2  ==> a:原值  x:平方根的可能值
 *     当 y = x 时
 *     公式可以化为 x^2 = a  ==>  得到 x 就是 a 的平方根
 *     解答成功:
 * 			执行耗时:1 ms,击败了100.00% 的Java用户
 * 			内存消耗:36.8 MB,击败了5.55% 的Java用户
 */
}