//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle{    
    public static void main(String[] args) {      
        Solution solution = new P118PascalsTriangle().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                } else {
                    list.add(1);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 暴力破解法: 循环添加, 中间的等于前一列的两个数相加
 *     解答成功:
 * 			执行耗时:1 ms,击败了77.14% 的Java用户
 * 			内存消耗:37.3 MB,击败了61.92% 的Java用户
 */
}