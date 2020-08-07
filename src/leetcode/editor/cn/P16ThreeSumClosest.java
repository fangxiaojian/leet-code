//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest{    
    public static void main(String[] args) {      
        Solution solution = new P16ThreeSumClosest().new Solution();       
        // TO TEST	 
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDifferenceValue = Integer.MAX_VALUE;
        if (nums.length <= 0) {
            return 0;
        } else if (nums.length <= 3) {
            minDifferenceValue = nums[0];
            for (int i = 1; i < nums.length; i++) {
                minDifferenceValue += nums[i];
            }
            return minDifferenceValue;
        }
        // 排序
        Arrays.sort(nums);

        int p1 = 0, p2 = 1, p3 = 2;
        int temp = 0;
        while (p3 < nums.length) {
            temp = nums[p1] + nums[p2] + nums[p3];
            if (Math.abs(temp - target) > Math.abs(target - minDifferenceValue)) {
                return minDifferenceValue;
            }
            minDifferenceValue = temp;
            // 移动指针
            if (p3 + 1 < nums.length) {
                if (nums[p3 + 1] - nums[p3] <= nums[p2 + 1] - nums[p2] && nums[p3 + 1] - nums[p3] <= nums[p1 + 1] - nums[p1]) {
                    p3++;
                } else if (nums[p2 + 1] - nums[p2] <= nums[p3 + 1] - nums[p3] && nums[p2 + 1] - nums[p2] <= nums[p1 + 1] - nums[p1]) {
                    if (p2 + 1 == p3) {
                        p3++;
                    } else {
                        p2++;
                    }
                } else {
                    if (p1 + 1 == p2) {
                        if (p2 + 1 == p3) {
                            p3++;
                        } else {
                            p2++;
                        }
                    } else {
                        p1++;
                    }
                }
            } else {
                if (p2 + 1 == p3) {
                    if (p1 + 1 == p2) {
                        break;
                    } else {
                        p1++;
                    }
                } else {
                    if (nums[p2 + 1] - nums[p2] <= nums[p1 + 1] - nums[p1]) {
                        p2++;
                    } else {
                        if (p1 + 1 == p2) {
                            p2++;
                        } else {
                            p1++;
                        }
                    }
                }
            }
        }
        return minDifferenceValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}