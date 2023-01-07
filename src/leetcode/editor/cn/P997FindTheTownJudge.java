//在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足属性 1 和属性 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：N = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 输入：N = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 输入：N = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// trust.length <= 10000 
// trust[i] 是完全不同的 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= N 
// 
// Related Topics 图 
// 👍 91 👎 0


package leetcode.editor.cn;
//Java：找到小镇的法官
public class P997FindTheTownJudge{    
    public static void main(String[] args) {      
        Solution solution = new P997FindTheTownJudge().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findJudge(int N, int[][] trust) {
        // 特殊情况,小镇只有一个人
        if (trust == null || trust.length == 0) {
            return N == 1 ? N : -1;
        }
        int[] results = new int[N];
        // 将有信任别人的人标记
        for (int[] ints : trust) {
            results[ints[0] - 1] += 1;
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            // 找出没有信任别人的人
            if (results[i] == 0) {
                int num = 0;
                // 遍历查找这个人是否被小镇所有人信任
                for (int[] ints : trust) {
                    if (ints[1] == i + 1) {
                        num++;
                    }
                }
                if (num == N-1) {
                    count++;
                    result = i + 1;
                }
            }
        }
        // 不止一人符合,返回-1
        return count == 1 ? result : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:2 ms,击败了100.00% 的Java用户
 * 		内存消耗:46.1 MB,击败了71.40% 的Java用户
 */
}