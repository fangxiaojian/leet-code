//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn;
//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock{    
    public static void main(String[] args) {      
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();       
        // TO TEST
        int[] prices = {5,7,2,7,3,3,5,3,0};
        System.out.println(solution.maxProfit(prices));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int tempMaxPorfit = 0;
        int max = 0;
        int min = 0;
        int border = 0;
        int temp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                min = prices[i];
                border = i;
                temp = i;
                tempMaxPorfit = prices[i + 1] - min;
                break;
            }
        }
        if (tempMaxPorfit == 0) {
            return tempMaxPorfit;
        }
        // 定位0
        for (int i = border + 1; i < prices.length; i++) {
            if (prices[i] == 0) {
                min = prices[i];
                temp = i;
                for (int j = temp + 1; j < prices.length; j++) {
                    max = Math.max(max, prices[j]);
                }
                tempMaxPorfit = Math.max(max, tempMaxPorfit);
            }
        }

        // 定位最小值
        min = prices[border];
        for (int i = border + 1; i < prices.length; i++) {
            if (min > prices[i] && prices[i] != 0) {
                min = prices[i];
                temp = i;
            }
        }
        // 找到最小值右边的最大值
        for (int i = temp + 1; i < prices.length; i++) {
            max = Math.max(max, prices[i]);
        }
        tempMaxPorfit = Math.max(max - min, tempMaxPorfit);

        // 定位最大值
        max = prices[border + 1];
        temp = border + 1;
        for (int i = temp + 1; i < prices.length; i++) {
            if (max < prices[i]) {
                max = prices[i];
                temp = i;
            }
        }
        // 找到最大值左边的最小值
        min = prices[--temp];
        for (int i = temp - 1; i >= border; i--) {
            min = Math.min(min, prices[i]);
        }

        return Math.max(max - min, tempMaxPorfit);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 暴力, 分多钟情况进行判断  ----> 不可取
 *      a. 查询边界, 即 prices[i]<prices[i+1]  i左边的不需要考虑  只考虑右边
 *      b. 查询prices[i]==0 的情况, 查询右边最大值, 计算收益
 *      c. 查询最小值, 之后查询右边最大值, 计算收益
 *      d. 查询最大值 ,之后查询左边最小值, 计算收益
 *      e. 返回最大收益
 *      解答成功:
 * 			执行耗时:123 ms,击败了18.78% 的Java用户
 * 			内存消耗:40 MB,击败了13.63% 的Java用户
 */
}