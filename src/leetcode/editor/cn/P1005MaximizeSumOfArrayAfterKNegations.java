//给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选
//择同一个索引 i。） 
//
// 以这种方式修改数组后，返回数组可能的最大和。 
//
// 
//
// 示例 1： 
//
// 输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
// 
//
// 示例 2： 
//
// 输入：A = [3,-1,0,2], K = 3
//输出：6
//解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
// 
//
// 示例 3： 
//
// 输入：A = [2,-3,-1,5,-4], K = 2
//输出：13
//解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics 贪心算法 
// 👍 63 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：K 次取反后最大化的数组和
public class P1005MaximizeSumOfArrayAfterKNegations{    
    public static void main(String[] args) {      
        Solution solution = new P1005MaximizeSumOfArrayAfterKNegations().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length < 0) {
            return 0;
        }
        Arrays.sort(A);
        if (A[0] >= 0) {
            if (K % 2 != 0) {
                A[0] *= -1;
            }
            return numAdd(A);
        }
        for (int i = 0; i < K; i++) {
            if (A[i] == 0) {
                return numAdd(A);
            } else if (A[i] > 0) {
                if (A[i] >= A[i - 1]) {
                    if ((K - i) % 2 != 0) {
                        A[i - 1] *= -1;
                    }
                } else {
                    if ((K - i) % 2 != 0) {
                        A[i] *= -1;
                    }
                }
                return numAdd(A);
            } else {
                A[i] *= -1;
            }
        }
        return numAdd(A);
    }

    private int numAdd(int[] a) {
        int add = 0;
        for (int value : a) {
            add += value;
        }
        return add;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:2 ms,击败了86.34% 的Java用户
 * 		内存消耗:38.7 MB,击败了28.83% 的Java用户
 */
}