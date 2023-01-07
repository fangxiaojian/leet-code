//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;
//Java：删除排序数组中的重复项
public class P26RemoveDuplicatesFromSortedArray{    
    public static void main(String[] args) {      
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();       
        // TO TEST
        int[] nums = {1, 2, 2};
        System.out.println(solution.removeDuplicates(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int oldNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > oldNum && count < i) {
                nums[count++] = nums[i];
                oldNum = nums[i];
            } else if (nums[i] > oldNum && count == i) {
                count++;
                oldNum = nums[i];
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 *思路:
 * 1. 暴力破解:
 *    利用已排序的特性, 记录最新的数字, 若当前数比它大, 则更新, 并将这个数保存到数组对应的位置
 *    P.S. 当前位置就是其对应的位置, 则数量+1, 并且更新最新数字.
 *    解答成功:
 * 			执行耗时:1 ms,击败了98.29% 的Java用户
 * 			内存消耗:41.7 MB,击败了5.74% 的Java用户
 *
 */
}