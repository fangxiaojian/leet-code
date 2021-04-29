//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 188 👎 0


package leetcode.editor.cn;
//Java：按奇偶排序数组 II
public class P922SortArrayByParityIi{    
    public static void main(String[] args) {      
        Solution solution = new P922SortArrayByParityIi().new Solution();       
        // TO TEST
        int[] A = {2, 3, 3, 1, 4, 4, 0, 0, 1, 3};
        solution.sortArrayByParityII(A);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length <= 0) {
            return A;
        }
        int first = 0;
        int last = A.length - 1;
        while (first <= A.length-1 && last >= 0) {
            if (first % 2 == 0 && A[first] % 2 == 0) {
                first+=2;
                continue;
            }
            if (last % 2 != 0 && A[last] % 2 != 0) {
                last-=2;
                continue;
            }
            int temp = A[first];
            A[first] = A[last];
            A[last] = temp;
            first+=2;
            last-=2;
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 双指针
 * 一个遍历奇数,一个遍历偶数
 * 解答成功:
 * 		执行耗时:3 ms,击败了78.94% 的Java用户
 * 		内存消耗:39.7 MB,击败了68.66% 的Java用户
 */
}