//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum{    
    public static void main(String[] args) {      
        Solution solution = new P15ThreeSum().new Solution();       
        // TO TEST
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List list : lists) {
            for (Object i : list) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 判断数组是否为null
        if (nums == null || nums.length < 3) {
            return lists;
        }
        // 先将数组进行排序
        Arrays.sort(nums);
        // 利用双指针进行计算
        int p1 = 0, p2 = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                i++;
                while (i + 1 < nums.length && nums[i-1] == nums[i]) {
                    i++;
                }
                if (i >= nums.length - 3) {
                    break;
                }
            }
            p1 = i + 1;
            p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[i] + nums[p1] + nums[p2] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    lists.add(list);
                    if (nums[p1] == nums[p1 + 1]) {
                        while (p1 + 1 < nums.length && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }
                        if (nums[p1] != nums[p2]) {
                            p1++;
                        }
                    } else {
                        p1++;
                    }
                } else if (nums[i] + nums[p1] + nums[p2] < 0) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 * 1. 暴力破解法: 循环遍历数组, 以当前节点为界限
 *     利用双指针的方法,p1\p2, 从左右两边往中间遍历当前节点的右边界
 *     循环条件(p1<p2)
 *         若3个数相加==0, 存入list集合中, 并将左节点p1向前推进至不与原节点相同的位置
 *         (如:p1==p2==[2]-->p1==[最后一个2], p1==[2],p2!=[2]-->p1!=[2])
 *         若3个数相加<0, 左节点p1向前推进1位
 *         若3个数相加>0, 右节点p2向左退后1位
 *     循环结束
 *     当前节点前进一位, 至于上一个节点不重复的位置
 *     解答成功:
 * 			执行耗时:25 ms,击败了59.73% 的Java用户
 * 			内存消耗:43.8 MB,击败了47.34% 的Java用户
 */
}