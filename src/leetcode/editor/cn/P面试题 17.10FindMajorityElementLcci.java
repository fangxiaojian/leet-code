//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 34 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：主要元素
class P面试题1710FindMajorityElementLcci{
    public static void main(String[] args) {      
        Solution solution = new P面试题1710FindMajorityElementLcci().new Solution();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]);
            }
            if (++count > nums.length / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:17 ms,击败了21.45% 的Java用户
 * 		内存消耗:43.9 MB,击败了21.48% 的Java用户
 */
}