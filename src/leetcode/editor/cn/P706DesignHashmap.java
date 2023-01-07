//不使用任何内建的哈希表库设计一个哈希映射 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
// get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
// remove(key)：如果映射中存在这个键，删除这个数值对。 
// 
//
// 
//示例： 
//
// MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);          
//hashMap.put(2, 2);         
//hashMap.get(1);            // 返回 1
//hashMap.get(3);            // 返回 -1 (未找到)
//hashMap.put(2, 1);         // 更新已有的值
//hashMap.get(2);            // 返回 1 
//hashMap.remove(2);         // 删除键为2的数据
//hashMap.get(2);            // 返回 -1 (未找到) 
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希库。 
// 
// Related Topics 设计 哈希表 
// 👍 92 👎 0


package leetcode.editor.cn;
//Java：设计哈希映射
public class P706DesignHashmap{    
    public static void main(String[] args) {
        MyHashMap solution = new P706DesignHashmap().new MyHashMap();
        // TO TEST
        solution.put(1, 1);
        solution.put(2, 2);
        solution.remove(2);
        System.out.println(solution.get(2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class MyHashMap {

    private int size = 16;
    private LinkNode[] nums;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nums = new LinkNode[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (nums[key % size] == null) {
            nums[key % size] = new LinkNode(key, value);
        } else {
            LinkNode node = nums[key % size];
            if (node.key == key) {
                node.value = value;
                return;
            }
            while (node.next != null) {
                node = node.next;
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
            node.next = new LinkNode(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (nums[key % size] != null) {
            LinkNode node = nums[key % size];
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                } else {
                    node = node.next;
                }
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (nums[key % size] != null) {
            if (nums[key % size].key == key) {
                nums[key % size] = nums[key % size].next;
            }else {
                LinkNode node = nums[key % size];
                LinkNode p = node.next;
                while (p != null && p.key != key) {
                    node = node.next;
                    p = p.next;
                }
                if (p != null) {
                    node.next = p.next;
                }
            }
        }
    }
    class LinkNode {
        public int value;
        public int key;
        public LinkNode next;

        public LinkNode() {}

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:44 ms,击败了22.22% 的Java用户
 * 		内存消耗:41 MB,击败了97.53% 的Java用户
 */
}