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
                break;
            }
        }
        if (min == 0) {
            return tempMaxPorfit;
        }
        // 定位最小值
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
        tempMaxPorfit = Math.max((max - min), 0);

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

}