//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum{    
    public static void main(String[] args) {      
        Solution solution = new P1TwoSum().new Solution();       
        // TO TEST
        int [] nums = {2, 5, 5, 11};
        int target = 10;
        int[] result = solution.twoSum(nums, target);
        System.out.println(result[0] + "  :  " + result[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        /**
         * 通过映射
         */
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
        /**
         * 需要排好序的数组
         */
//        int left = 0;
//        int right = nums.length-1;
//        while (left < right) {
//            if (nums[left] + nums[right] == target) {
//                return new int[]{left, right};
//            } else {
//                if (nums[left] + nums[right] > target) {
//                    right--;
//                } else {
//                    left++;
//                }
//            }
//        }
//        return null;

/**
 * 思路
 *
 * 1. 暴力破解：直接两个循环遍历，找出结果，但是可能会超时-----放弃
 * 2. 假设数组是已排好序的：
 *        从左右两边遍历，相加>target 右-1，相加<target 左+1
 *        但 数组不是已排好序的  --- Over
 * 3. 映射
 *        通过Map来做, key---数组值, value---数组值的下标
 *        通过判断Map中是否存储了key为(target-nums[i]) 来判断
 *
 *        解答成功:
 * 			执行耗时:2 ms,击败了99.62% 的Java用户
 * 			内存消耗:40.2 MB,击败了5.06% 的Java用户
 *
 *        PS: 这种牺牲了空间,但是访问时间比较快.
 */

}