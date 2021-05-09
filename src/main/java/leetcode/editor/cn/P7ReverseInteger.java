//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学


package leetcode.editor.cn;
//Java：整数反转
public class P7ReverseInteger{    
    public static void main(String[] args) {      
        Solution solution = new P7ReverseInteger().new Solution();       
        // TO TEST
        int x = -2147483648;
        System.out.println(solution.reverse(x));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean isFlag = false;
        if (x < 0) {
            isFlag = true;
            x *= -1;
        }
        while (x != 0) {
            if (result > (Integer.MAX_VALUE-(x % 10))/10){
                return 0;
            }
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return isFlag ? (-1 * result) : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     测试用例:1534236469
 *     需注意测试用例符合 int 的取值范围， 但是其翻转数不一定符合。
 *
 *     解答成功:
 * 			执行耗时:1 ms,击败了100.00% 的Java用户
 * 			内存消耗:36.8 MB,击败了5.33% 的Java用户
  */

}