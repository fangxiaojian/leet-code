//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学 
// 👍 59 👎 0


package leetcode.editor.cn;
//Java：最大数值
class P面试题1607MaximumLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1607MaximumLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maximum(int a, int b) {
        int k = (a ^ b) >>> 31;
        return k * (a * ((a >> 31) + 1) + b * ((b >> 31) + 1)) +
                ((k-1)>>>31) * (((a - b) >>> 31 ^ 1) * a + ((((a - b) >>> 31) + 1) & 1 ^ 1) * b);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.4 MB,击败了81.41% 的Java用户
 */
}