//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 571 👎 0


package leetcode.editor.cn;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum{    
    public static void main(String[] args) {      
        Solution solution = new P239SlidingWindowMaximum().new Solution();       
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        // 记录当前窗口最大值的下标
        int temp = -1;
        int max = 0;

        for (int i = k - 1; i < nums.length; i++) {
            /*  添加队列的方法
            队列中存放当前窗口的最大值
            当队列为 null 时,需要添加队列
            当队列最大值是需要移除的元素时, 需要添加队列
            当下个元素大于上个窗口的最大值时,也需要添加队列
             */
            if (temp == -1 || i - k == temp || nums[i] > max) {
                // 队列最大值是需要移除的元素
                if (i - k == temp) {
                    temp++;
                    max = nums[temp];
                }
                // 循环整个窗口, 找到最大值
                for (int j = temp; j <= i; j++) {
                    if (temp == -1 || nums[j] > max) {
                        max = nums[j];
                        temp = j;
                    }
                }
            }
            result[index++] = max;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 1. 暴力模式
 *      解答成功:
 * 			执行耗时:755 ms,击败了13.82% 的Java用户
 * 			内存消耗:60.3 MB,击败了5.01% 的Java用户
 */
}