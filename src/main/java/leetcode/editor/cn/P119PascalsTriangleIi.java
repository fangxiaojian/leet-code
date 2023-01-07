//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
public class P119PascalsTriangleIi{    
    public static void main(String[] args) {      
        Solution solution = new P119PascalsTriangleIi().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int lastTemp = 0;
        int temp = 0;
        for (int i = 1; i <= rowIndex; i++) {
            lastTemp = list.get(0);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    list.add(1);
                }else {
                    temp = lastTemp + list.get(j);
                    lastTemp = list.get(j);
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 算计杨辉三角
 *     只储存最后一行
 *     解答成功:
 * 			执行耗时:2 ms,击败了49.43% 的Java用户
 * 			内存消耗:37.1 MB,击败了77.14% 的Java用户
 */
}