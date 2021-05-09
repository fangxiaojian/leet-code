//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 2^31.
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 337 👎 0


package leetcode.editor.cn;
//Java：汉明距离
public class P461HammingDistance{    
    public static void main(String[] args) {      
        Solution solution = new P461HammingDistance().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: x 与 y 进行异或操作, 同为 1 的位置变为 0
 *      再计算 我二进制中 1 的个数即可
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.4 MB,击败了89.68% 的Java用户
 */
}