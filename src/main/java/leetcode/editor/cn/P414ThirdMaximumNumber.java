//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 164 👎 0


package leetcode.editor.cn;
//Java：第三大的数
public class P414ThirdMaximumNumber{    
    public static void main(String[] args) {      
        Solution solution = new P414ThirdMaximumNumber().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int max1 = nums[0];
        int max2 = 0, max3 = 0;
        boolean flag1 = false, flag2 = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max1) {
                if (!flag1) {// 第二大的数为空
                    flag1 = true;
                } else {
                    if (!flag2) { // 第三大的数为空
                        flag2 = true;
                    }
                    max3 = max2;
                }
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] < max1) { // 数组的元素 < 最大的数
                if (!flag1) { // 第二大的数为空
                    flag1 = true;
                    max2 = nums[i];
                } else {
                    if (nums[i] > max2) {
                        if (!flag2) {
                            flag2 = true;
                        }
                        max3 = max2;
                        max2 = nums[i];
                    } else if (nums[i] < max2 && (!flag2 || max3 < nums[i])) { // 判断当前元素是否为第三大数
                        flag2 = true;
                        max3 = nums[i];
                    }
                }
            }
        }
        return flag2 ? max3 : max1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：
 *     1. 不推荐：直接将遇到的情况判断出来
 *         用3个容器存放最大到第三大三个数，若存放到第三个容器，返回第三大的数，否则返回最大的数。
 *         解答成功:
 * 			  执行耗时:1 ms,击败了96.62% 的Java用户
 * 			  内存消耗:38.6 MB,击败了64.72% 的Java用户
 */
}