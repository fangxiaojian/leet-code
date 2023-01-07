//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。 
//
// 如果不能形成任何面积不为零的三角形，返回 0。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[2,1,2]
//输出：5
// 
//
// 示例 2： 
//
// 输入：[1,2,1]
//输出：0
// 
//
// 示例 3： 
//
// 输入：[3,2,3,4]
//输出：10
// 
//
// 示例 4： 
//
// 输入：[3,6,2,3]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 10000 
// 1 <= A[i] <= 10^6 
// 
// Related Topics 排序 数学 
// 👍 134 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：三角形的最大周长
public class P976LargestPerimeterTriangle{    
    public static void main(String[] args) {      
        Solution solution = new P976LargestPerimeterTriangle().new Solution();       
        // TO TEST
        int[] A = {3, 9, 2, 5, 2, 19};
        solution.largestPerimeter(A);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int index = A.length - 2;
        while (index - 1 >= 0) {
            if (A[index + 1] < A[index - 1] + A[index] ) {
                return A[index] + A[index - 1] + A[index + 1];
            } else {
                index--;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:9 ms,击败了62.46% 的Java用户
 * 		内存消耗:38.8 MB,击败了85.49% 的Java用户
 */
}