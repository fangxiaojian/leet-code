//你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。 
//
// 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。 
//
// 示例: 
//
// 输入: 4
//输出: false 
//解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
//     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
// 
// Related Topics 脑筋急转弯 极小化极大 
// 👍 370 👎 0


package leetcode.editor.cn;
//Java：Nim 游戏
public class P292NimGame{    
    public static void main(String[] args) {      
        Solution solution = new P292NimGame().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 只要石子的数量不是 4 的倍数, 你取掉1-3个石子, 将石子的数量控制在4的倍数
 *    对方拿掉多少石子, 你就在原有的基础上拿掉 1-3 个石子, 使石子的数量保持在 4 的倍数
 *    你将赢得比赛
 * 解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:36 MB,击败了5.55% 的Java用户
 */
}