//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 174 👎 0


package leetcode.editor.cn;
//Java：三个数的最大乘积
public class P628MaximumProductOfThreeNumbers{    
    public static void main(String[] args) {      
        Solution solution = new P628MaximumProductOfThreeNumbers().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -1, max2 = -1, max3 = -1;
        int fMax1 = 0, fMax2 = 0;
        if (nums.length <= 3) {
            return nums[0] * nums[1] * nums[2];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] > max3) {
                    if (max3 >= max2) {
                        if (max2 > max1) {
                            max1 = max2;
                        }
                        max2 = max3;
                    }
                    max3 = nums[i];
                } else if (nums[i] > max2) {
                    if (max2 > max1) {
                        max1 = max2;
                    }
                    max2 = nums[i];
                } else if (nums[i] > max1) {
                    max1 = nums[i];
                }
            } else if (nums[i] < 0) {
                if (nums[i] < fMax2) {
                    if (fMax2 < fMax1) {
                        fMax1 = fMax2;
                    }
                    fMax2 = nums[i];
                } else if (nums[i] < fMax1) {
                    fMax1 = nums[i];
                }
            }
        }
        if (max1 == -1) {
            if (max2 == -1) {
                return fMax1 * fMax2 * max3;
            } else {
                if (fMax1 != 0) {
                    return fMax1 * fMax2 * max3;
                } else {
                    return max2 * fMax2 * max3;
                }
            }
        }

        if (fMax1 * fMax2 > max1 * max2) {
            return fMax1 * fMax2 * max3;
        }else {
            return max1 * max2 * max3;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:3 ms,击败了83.08% 的Java用户
 * 		内存消耗:41 MB,击败了8.11% 的Java用户
 */
}