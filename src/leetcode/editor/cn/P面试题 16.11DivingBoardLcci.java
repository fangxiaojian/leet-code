//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
//
// 返回的长度需要从小到大排列。 
//
// 示例 1 
//
// 输入：
//shorter = 1
//longer = 2
//k = 3
//输出： [3,4,5,6]
//解释：
//可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。 
//
// 提示： 
//
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 递归 记忆化 
// 👍 71 👎 0


package leetcode.editor.cn;
//Java：跳水板
class P面试题1611DivingBoardLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1611DivingBoardLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] nums = new int[k + 1];
        int temp = shorter * k;
        for (int i = 0; i < k + 1; i++) {
            nums[i] = temp;
            temp += longer-shorter;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:2 ms,击败了92.08% 的Java用户
 * 		内存消耗:46.9 MB,击败了16.79% 的Java用户
 */
}