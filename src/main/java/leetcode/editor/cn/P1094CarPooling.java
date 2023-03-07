package leetcode.editor.cn;

//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 227 👎 0

import java.util.*;

public class P1094CarPooling{

    public static void main(String[] args) {
        Solution solution = new P1094CarPooling().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int person = 0;
        Map<Integer, Integer> tripUpMap = new TreeMap<>();
        Map<Integer, Integer> tripDownMap = new TreeMap<>();
        for (int[] trip : trips) {
            if (tripUpMap.containsKey(trip[1])) {
                tripUpMap.put(trip[1], tripUpMap.get(trip[1]) + trip[0]);
            }else {
                tripUpMap.put(trip[1], trip[0]);
            }

            if (tripDownMap.containsKey(trip[2])) {
                tripDownMap.put(trip[2], tripDownMap.get(trip[2]) + trip[0]);
            }else {
                tripDownMap.put(trip[2],trip[0]);
            }
        }
        while (!tripUpMap.isEmpty()) {
            Integer temp = tripUpMap.keySet().iterator().next();
            person += tripUpMap.get(temp);
            tripUpMap.remove(temp);
            while (person > capacity) {
                Integer downTrip = tripDownMap.keySet().iterator().next();
                if (downTrip > temp) {
                    return false;
                }
                person -= tripDownMap.get(downTrip);
                tripDownMap.remove(downTrip);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 思路：封装两个已排序集合，分别记录公里数与上车人数、 公里数与下车人数
 *      计算是否符合条件
 * 解答成功:
 * 	执行耗时:8 ms,击败了6.78% 的Java用户
 * 	内存消耗:41.3 MB,击败了29.17% 的Java用户
 */
}