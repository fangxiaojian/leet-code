//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 11 👎 0


package leetcode.editor.cn;
//Java：整数转换
class P面试题0506ConvertIntegerLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0506ConvertIntegerLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 计算 A B 不同的位数
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.4 MB,击败了73.40% 的Java用户
 */
}