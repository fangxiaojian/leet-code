//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 
// 👍 22 👎 0


package leetcode.editor.cn;
//Java：不用加号的加法
class P面试题1701AddWithoutPlusLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1701AddWithoutPlusLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int add(int a, int b) {
        int x = a | b;
        int y = a & b;
        if (y != 0) {
            return add(x^y, y << 1);
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.4 MB,击败了79.55% 的Java用户
 */
}