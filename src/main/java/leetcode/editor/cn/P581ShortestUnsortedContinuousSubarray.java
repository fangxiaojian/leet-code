//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 404 👎 0


package leetcode.editor.cn;
//Java：最短无序连续子数组
public class P581ShortestUnsortedContinuousSubarray{    
    public static void main(String[] args) {      
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();       
        // TO TEST
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int index = 0;
        int last = 0;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] < nums[i - 1]) {
                last = i;
                break;
            }
        }
        // 遍历 index 到 last 之间的元素, 找到最小值及最大值
        int min = nums[index];
        int max = nums[index];
        for (int i = index; i <= last; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                break;
            } else {
                index = i;
            }
        }
        for (int i = last + 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                break;
            } else {
                last = i;
            }
        }

        if (last == index) {
            return 0;
        }
        return last - index + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:1 ms,击败了100.00% 的Java用户
 * 		内存消耗:40.4 MB,击败了6.95% 的Java用户
 */
}