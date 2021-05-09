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
        int[] nums = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
        int taget = -275;
        System.out.println(solution.threeSumClosest(nums, taget));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int temp = 0;
        if (nums.length <= 0) {
            return 0;
        } else if (nums.length <= 3) {
            temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                temp += nums[i];
            }
            return temp;
        }
        // 排序
        Arrays.sort(nums);
        int p1 = 0, p2 = 1, p3 = 2;
        int minValue = nums[p1] + nums[p2] + nums[p3];
        p3++;
        while (p3 < nums.length) {
            temp = nums[p1] + nums[p2] + nums[p3];
//            if (temp >= target) {
//                if (Math.abs(target - minValue) > Math.abs(temp - target)) {
//                    minValue = temp;
//                }else {
//                    p1= 0;
//                    if (p2 + 1 == p3) {
//                        p2 = 1;
//                        p3++;
//                    }else {
//                        p2++;
//                    }
//                    continue;
//                }
//            }else {
//                if (Math.abs(target - minValue) >= Math.abs(target - temp)) {
//                    minValue = temp;
//                }else {
//                    p1= 0;
//                    if (p2 + 1 == p3) {
//                        p2 = 1;
//                        p3++;
//                    }else {
//                        p2++;
//                    }
//                    continue;
//                }
//            }
            if (Math.abs(target - minValue) > Math.abs(target - temp)) {
                minValue = temp;
            }
            if (p1 + 1 == p2) {
                p1 = 0;
                if (p2 + 1 == p3) {
                    p2 = 1;
                    p3++;
                } else {
                    p2++;
                }
            } else {
                p1++;
            }
        }
        return minValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     利用二进制的方式,往前进一
 *     解答成功:
 * 			执行耗时:201 ms,击败了5.00% 的Java用户
 * 			内存消耗:39.4 MB,击败了48.97% 的Java用户
 * 	   改进思路: 减少往前进一的步数
 */
}