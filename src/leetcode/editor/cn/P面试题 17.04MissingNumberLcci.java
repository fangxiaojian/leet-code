//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？ 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例 1： 
//
// 输入：[3,0,1]
//输出：2 
//
// 
//
// 示例 2： 
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
// 
// Related Topics 位运算 数组 数学 
// 👍 22 👎 0


package leetcode.editor.cn;
//Java：消失的数字
class P面试题1704MissingNumberLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1704MissingNumberLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int missingNumber(int[] nums) {
        int[] newNums = new int[nums.length + 1];
        for (int num : nums) {
            newNums[num] = num;
        }
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] == 0 && i != 0) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:38.5 MB,击败了99.71% 的Java用户
 */
}