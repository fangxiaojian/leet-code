//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(11011101111)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(0111)
//输出: 4
// 
// Related Topics 位运算 
// 👍 18 👎 0


package leetcode.editor.cn;

//Java：翻转数位
class P面试题0503ReverseBitsLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题0503ReverseBitsLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int reverseBits(int num) {
        String[] split = Integer.toBinaryString(num).split("0");
        int max = 0;
        int temp = 0;
        for (String s : split) {
            temp += s.length();
            max = Math.max(max, Math.min(temp + 1, 32));
            temp = s.length();
        }

        return max == 0 ? 1 : max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了27.00% 的Java用户
 * 		内存消耗:35.6 MB,击败了61.24% 的Java用户
 */
}