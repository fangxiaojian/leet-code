//给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。 
//
// 示例 1: 
//
// 
//输入: 5
//输出: True
//解释:
//5的二进制数是: 101
// 
//
// 示例 2: 
//
// 
//输入: 7
//输出: False
//解释:
//7的二进制数是: 111
// 
//
// 示例 3: 
//
// 
//输入: 11
//输出: False
//解释:
//11的二进制数是: 1011
// 
//
// 示例 4: 
//
// 
//输入: 10
//输出: True
//解释:
//10的二进制数是: 1010
// 
// Related Topics 位运算 
// 👍 79 👎 0


package leetcode.editor.cn;
//Java：交替位二进制数
public class P693BinaryNumberWithAlternatingBits{    
    public static void main(String[] args) {      
        Solution solution = new P693BinaryNumberWithAlternatingBits().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n <= 1) {
            return true;
        }
        while (n != 0 && ((n & 1) ^ ((n >>> 1) & 1)) == 1){
            n = n >>> 1;
        }

        return n == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * ((n & 1) ^ ((n >>> 1) & 1)) == 1 判断 后两位 是否不同
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.6 MB,击败了56.60% 的Java用户
 */
}