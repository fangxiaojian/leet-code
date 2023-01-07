//三枚石子放置在数轴上，位置分别为 a，b，c。 
//
// 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位
//置 k 处，其中 x < k < z 且 k != y。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximu
//m_moves] 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 2, c = 5
//输出：[1, 2]
//解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
// 
//
// 示例 2： 
//
// 输入：a = 4, b = 3, c = 2
//输出：[0, 0]
//解释：我们无法进行任何移动。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 100 
// 1 <= b <= 100 
// 1 <= c <= 100 
// a != b, b != c, c != a 
// 
// Related Topics 脑筋急转弯 
// 👍 26 👎 0


package leetcode.editor.cn;
//Java：移动石子直到连续
public class P1033MovingStonesUntilConsecutive{    
    public static void main(String[] args) {      
        Solution solution = new P1033MovingStonesUntilConsecutive().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] movesCount = new int[2];
        if (a > b || a > c) {
            int temp = a;
            if (b < c) {
                a = b;
                b = temp;
            } else {
                a = c;
                c = temp;
            }
        }
        if (c < b) {
            int temp = c;
            c = b;
            b = temp;
        }
        if (a < b - 1) {
            movesCount[0]++;
            movesCount[1] += b - 1 - a;
        }
        if (c > b + 1) {
            movesCount[0]++;
            movesCount[1] += c - b - 1;
        }
        if (a + 2 == b || b + 2 == c) {
            movesCount[0] = 1;
        }
        return movesCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了65.14% 的Java用户
 * 		内存消耗:36.9 MB,击败了19.37% 的Java用户
 */
}