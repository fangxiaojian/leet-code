//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 691 👎 0


package leetcode.editor.cn;
//Java：旋转数组
public class P189RotateArray{
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
        int[] numbers = {1,2,3,4,5,6,7};
        int k = 2;
        solution.rotate(numbers, k);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k > 0) {
            int index = 0;
            int temp = nums[index];
            int temp1 = 0;
            int[] flag = new int[k];
            for (int i = 0; i < k; i++) {
                flag[i] = nums[nums.length - k + i];
            }
            for (int i = 0; i < nums.length-k; i++) {
                nums[nums.length - i-1] = nums[nums.length - k - i - 1];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = flag[i];
            }
        }
    }
}
//1
//class Solution {
//    public void rotate(int[] nums, int k) {
//        if (k > 0) {
//            int index = 0;
//            int temp = nums[index];
//            int temp1 = 0;
//            int[] flag = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                temp1 = nums[(index + k) % nums.length];
//                nums[(index + k) % nums.length] = temp;
//                flag[(index + k) % nums.length] = 1;
//                temp = temp1;
//                index = (index + k) % nums.length;
//                if (flag[(index + k) % nums.length] == 1) {
//                    index = (index+1)%nums.length;
//                    temp = nums[index];
//                }
//            }
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     1. 每个数字都有其对应的位置,计算每个数字的位置,直接替换
 *        需要注意的是有可能循环到已经替换数字的位置,但替换过程未结束
 *        解答成功:
 * 				执行耗时:1 ms,击败了57.06% 的Java用户
 * 				内存消耗:40.2 MB,击败了67.60% 的Java用户
 *
 * 	   2. 创建一个数组存放需要循环的后部分元素
 * 	      将前面的部分后移,再将之前后面的部分存放到前面
 * 	      解答成功:
 * 				执行耗时:1 ms,击败了57.06% 的Java用户
 * 				内存消耗:40.2 MB,击败了82.45% 的Java用户
 */
}