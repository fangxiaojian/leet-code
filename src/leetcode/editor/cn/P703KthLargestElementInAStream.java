//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 104 
// 0 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// -104 <= val <= 104 
// 最多调用 add 方法 104 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 堆 设计 
// 👍 163 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：数据流中的第 K 大元素
public class P703KthLargestElementInAStream{    
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest solution = new P703KthLargestElementInAStream().new KthLargest(k, nums);
        // TO TEST
        solution.add(10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// 2 替换
class KthLargest {

    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        Arrays.sort(nums);
        int index = nums.length-1;
        for (int i = 0; i < k; i++) {
            if (index >= 0) {
                this.nums[i] = nums[index--];
            }else {
                this.nums[i] = Integer.MIN_VALUE;
            }
        }
    }
    
    public int add(int val) {
        if (val > nums[k-1]) {
            for (int i = 0; i < k; i++) {
                if (val >= nums[i]){
                    int temp = nums[i];
                    nums[i] = val;
                    val = temp;
                }
            }
        }
        return nums[k-1];
    }
}
// 1. 插入
//class KthLargest {
//
//    private int k;
//    private int[] nums;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        this.nums = nums;
//        Arrays.sort(this.nums);
//    }
//
//    public int add(int val) {
//        if (nums.length < k || val > nums[nums.length - k]) {
//            int[] newNums = new int[nums.length + 1];
//            int index = 0;
//            for (int i = 0; i < newNums.length; i++) {
//                if (index < nums.length && nums[index] < val) {
//                    newNums[i] = nums[index++];
//                } else {
//                    newNums[i] = val;
//                    val = Integer.MAX_VALUE;
//                }
//            }
//            nums = newNums;
//        }
//        return nums[nums.length - k];
//    }
//}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 2. 将大于第K大的数替换原数组
 * 解答成功:
 * 		执行耗时:84 ms,击败了15.01% 的Java用户
 * 		内存消耗:42.4 MB,击败了91.93% 的Java用户
 *
 * 1. 将大于第K大的数插入原数组
 * 解答成功:
 * 		执行耗时:176 ms,击败了13.85% 的Java用户
 * 		内存消耗:44 MB,击败了27.58% 的Java用户
 */
}