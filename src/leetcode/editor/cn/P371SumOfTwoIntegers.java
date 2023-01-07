//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 314 👎 0


package leetcode.editor.cn;
//Java：两整数之和
public class P371SumOfTwoIntegers{    
    public static void main(String[] args) {      
        Solution solution = new P371SumOfTwoIntegers().new Solution();       
        // TO TEST
        System.out.println(5 | 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return carry == 0 ? sum : getSum(sum, carry);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * a ^ b 异或操作, 1^0=1,0^0=0,1^1=0
 * 计算完的 sum 是没有算上 进位的,需要在加上进位的
 * a & b 且操作, 同为 1 则 返回
 * 再想左移动一位, 相加得到的结果就是 a+b;
 *
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 	    内存消耗:35.6 MB,击败了37.10% 的Java用户
 */
}