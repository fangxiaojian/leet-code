//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 83 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最后一块石头的重量
public class P1046LastStoneWeight{    
    public static void main(String[] args) {      
        Solution solution = new P1046LastStoneWeight().new Solution();       
        // TO TEST
        int[] stones = {2, 7, 4, 1, 8, 1};
        solution.lastStoneWeight(stones);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length <= 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        while (stones[stones.length-1] != 0) {
            if (stones[stones.length-2] == 0) {
                return stones[stones.length-1];
            }
            int x = stones[stones.length-1];
            int y = stones[stones.length-2];
            x = x >= y ? x - y : y - x;
            stones[stones.length-1] = x;
            stones[stones.length-2] = 0;
            Arrays.sort(stones);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36.1 MB,击败了90.52% 的Java用户
 */
}