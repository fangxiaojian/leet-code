//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
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
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 116 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：滑动窗口的最大值
class P剑指Offer59IHuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {      
        Solution solution = new P剑指Offer59IHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        solution.maxSlidingWindow(nums, k);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || nums.length < k || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        // 记录当前窗口最大值的下标
        int temp = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = k - 1; i < nums.length; i++) {
            /*  添加队列的方法
            队列中存放当前窗口的最大值
            当队列为 null 时,需要添加队列
            当队列最大值是需要移除的元素时, 需要添加队列
            当下个元素大于上个窗口的最大值时,也需要添加队列
             */
            if (queue.isEmpty() || i - k == temp || nums[i] > queue.peek()) {
                // 队列为 null
                if (!queue.isEmpty()) {
                    queue.remove();
                }
                // 队列最大值是需要移除的元素
                if (i - k == temp) {
                    temp++;
                }
                // 循环整个窗口, 找到最大值
                for (int j = temp; j <= i; j++) {
                    if (queue.isEmpty()) {
                        queue.add(nums[j]);
                        temp = j;
                    } else if (nums[j] > queue.peek()) {
                        while (!queue.isEmpty() && nums[j] > queue.peek()) {
                            queue.remove();
                        }
                        queue.add(nums[j]);
                        temp = j;
                    }
                }
            }
            result[index++] = queue.peek();
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:8 ms,击败了89.32% 的Java用户
 * 		内存消耗:46.8 MB,击败了65.99% 的Java用户
 */
}