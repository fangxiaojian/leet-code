//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 398 👎 0


package leetcode.editor.cn;
//Java：两数之和 II - 输入有序数组
public class P167TwoSumIiInputArrayIsSorted{    
    public static void main(String[] args) {      
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();       
        // TO TEST
        int[] numbers = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538};
        int target = 542;
        int[] ints = solution.twoSum(numbers, target);
        System.out.println(ints[0] +":::" + ints[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1=0, index2=0;
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        if (numbers.length == 2) {
            result[0] = 1;
            result[1] = 2;
            return result;
        }
        for (int i = numbers.length-1; i >= 0; i--) {
            if (numbers[index1]+numbers[i] <= target) {
                index2 = i;
                break;
            }
        }
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] > target) {
                if (index2-1 == index1) {
                    index1--;
                } else {
                    index2--;
                }
            } else {
                if (index1 + 1 == index2) {
                    index2++;
                } else {
                    index1++;
                }
            }
        }

        result[0] = ++index1;
        result[1] = ++index2;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路: 从左右往中间遍历
 *      若小于, 则左+1,直到左+1==右,右+1
 *      若大于, 则右-1,直到右-1==左,左-1
 *      解答成功:
 * 			执行耗时:1 ms,击败了96.63% 的Java用户
 * 			内存消耗:39.9 MB,击败了73.95% 的Java用户
 */
}