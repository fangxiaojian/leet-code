//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 734 👎 0


package leetcode.editor.cn;
//Java：多数元素
public class P169MajorityElement{    
    public static void main(String[] args) {      
        Solution solution = new P169MajorityElement().new Solution();       
        // TO TEST
        int[] numbers = {3,2,3};
        System.out.println(solution.majorityElement(numbers));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int majorityElement(int[] nums) {
        int[][] index = new int[nums.length/2+1][2];
        int target = 0;
        for (int num : nums) {
            for (int j = 0; j < index.length; j++) {
                if ((index[j][0] == 0 && index[j][1]==0) || index[j][0] == num) {
                    target = j;
                    index[j][0] = num;
                    break;
                }
            }
            index[target][1]++;
            if (index[target][1]*2 >= nums.length) {
                return num;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路:
 *     创建一个元数组一半的数组用于记录个数,==>造成内存消耗大
 *     每查询一个数字都要遍历一遍数组查询  ===>造成消耗时间长
 *     解答成功:
 * 			执行耗时:8 ms,击败了33.40% 的Java用户
 * 			内存消耗:45 MB,击败了24.81% 的Java用户
 */
}