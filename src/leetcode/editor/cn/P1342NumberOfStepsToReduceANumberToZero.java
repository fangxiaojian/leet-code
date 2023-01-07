//给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。 
//
// 
//
// 示例 1： 
//
// 输入：num = 14
//输出：6
//解释：
//步骤 1) 14 是偶数，除以 2 得到 7 。
//步骤 2） 7 是奇数，减 1 得到 6 。
//步骤 3） 6 是偶数，除以 2 得到 3 。
//步骤 4） 3 是奇数，减 1 得到 2 。
//步骤 5） 2 是偶数，除以 2 得到 1 。
//步骤 6） 1 是奇数，减 1 得到 0 。
// 
//
// 示例 2： 
//
// 输入：num = 8
//输出：4
//解释：
//步骤 1） 8 是偶数，除以 2 得到 4 。
//步骤 2） 4 是偶数，除以 2 得到 2 。
//步骤 3） 2 是偶数，除以 2 得到 1 。
//步骤 4） 1 是奇数，减 1 得到 0 。
// 
//
// 示例 3： 
//
// 输入：num = 123
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10^6 
// 
// Related Topics 位运算 
// 👍 34 👎 0


package leetcode.editor.cn;
//Java：将数字变成 0 的操作次数
public class P1342NumberOfStepsToReduceANumberToZero{    
    public static void main(String[] args) {      
        Solution solution = new P1342NumberOfStepsToReduceANumberToZero().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        if (num == 0) {
            return count;
        }
        while (num != 0) {
            if ((num & 1) == 1 && num != 1) {
                count += 2;
            }else {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *      判断最后一位是否为 1, 为 1 则需要 减 1 后 除 2
 *      所有 最后一位为1,并且 本身不为 1 则 向坐移动一位, 步数 + 2
 *      否则 偶数 除 2, 向左移动一位, 步数 + 1
 *  解答成功:
 * 		执行耗时:0 ms,击败了100.00% 的Java用户
 * 		内存消耗:35.6 MB,击败了66.20% 的Java用户
 */
}