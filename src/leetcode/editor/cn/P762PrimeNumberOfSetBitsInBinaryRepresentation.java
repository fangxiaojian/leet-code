//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。 
//
// （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。） 
//
// 示例 1: 
//
// 
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
// 
//
// 示例 2: 
//
// 
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
// 
//
// 注意: 
//
// 
// L, R 是 L <= R 且在 [1, 10^6] 中的整数。 
// R - L 的最大值为 10000。 
// 
// Related Topics 位运算 
// 👍 46 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：二进制表示中质数个计算置位
public class P762PrimeNumberOfSetBitsInBinaryRepresentation{    
    public static void main(String[] args) {      
        Solution solution = new P762PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    private Set<Integer> primeNumber = new HashSet<>();
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrimeNumber(Integer.bitCount(i))) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeNumber(int n) {
        if (primeNumber.isEmpty()) {
            primeNumber.add(2);
            primeNumber.add(3);
            primeNumber.add(5);
            primeNumber.add(7);
            primeNumber.add(11);
            primeNumber.add(13);
            primeNumber.add(17);
            primeNumber.add(19);
            primeNumber.add(23);
            primeNumber.add(29);
            primeNumber.add(31);
        }
        return primeNumber.contains(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 暴力破解
 * 解答成功:
 * 		执行耗时:13 ms,击败了33.02% 的Java用户
 * 		内存消耗:35.7 MB,击败了52.26% 的Java用户
 */
}