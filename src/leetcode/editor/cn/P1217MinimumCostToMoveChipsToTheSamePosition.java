//数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。 
//
// 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）： 
//
// 
// 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。 
// 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。 
// 
//
// 最开始的时候，同一位置上也可能放着两个或者更多的筹码。 
//
// 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。 
//
// 
//
// 示例 1： 
//
// 输入：chips = [1,2,3]
//输出：1
//解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
// 
//
// 示例 2： 
//
// 输入：chips = [2,2,2,3,3]
//输出：2
//解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= chips.length <= 100 
// 1 <= chips[i] <= 10^9 
// 
// Related Topics 贪心算法 数组 数学 
// 👍 59 👎 0


package leetcode.editor.cn;
//Java：玩筹码
public class P1217MinimumCostToMoveChipsToTheSamePosition{    
    public static void main(String[] args) {      
        Solution solution = new P1217MinimumCostToMoveChipsToTheSamePosition().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int countOdd = 0;
        int countTwin = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                countTwin++;
            } else {
                countOdd++;
            }
        }
        return Math.min(countOdd, countTwin);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 移动 2 格 不用代价
 *      即单数的拼凑在一起不用代价
 *        双数的拼凑在一起也不用代价
 *        最后移动到相邻位置也不用代价
 *        所以代价只是把小的部分移动一格的代价
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.3 MB,击败了62.91% 的Java用户
 */
}