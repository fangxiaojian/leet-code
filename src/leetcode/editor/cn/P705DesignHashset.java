//不使用任何内建的哈希表库设计一个哈希集合 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// add(value)：向哈希集合中插入一个值。 
// contains(value) ：返回哈希集合中是否存在这个值。 
// remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 
//示例: 
//
// MyHashSet hashSet = new MyHashSet();
//hashSet.add(1);         
//hashSet.add(2);         
//hashSet.contains(1);    // 返回 true
//hashSet.contains(3);    // 返回 false (未找到)
//hashSet.add(2);          
//hashSet.contains(2);    // 返回 true
//hashSet.remove(2);          
//hashSet.contains(2);    // 返回  false (已经被删除)
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希集合库。 
// 
// Related Topics 设计 哈希表 
// 👍 70 👎 0


package leetcode.editor.cn;

//Java：设计哈希集合
public class P705DesignHashset{    
    public static void main(String[] args) {
        MyHashSet solution = new P705DesignHashset().new MyHashSet();
        // TO TEST  
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class MyHashSet {

    private int size = 16;
    private LinkNode[] nums;

    /** Initialize your data structure here. */
    public MyHashSet() {
        nums = new LinkNode[size];
    }
    
    public void add(int key) {
        if (nums[key % size] == null) {
            nums[key % size] = new LinkNode(key);
        } else {
            LinkNode node = nums[key % size];
            if (node.val == key) {
                return;
            }
            while (node.next != null) {
                node = node.next;
                if (node.val == key) {
                    return;
                }
            }
            node.next = new LinkNode(key);
        }
    }
    
    public void remove(int key) {
        if (nums[key % size] != null) {
            if (nums[key % size].val == key) {
                nums[key % size] = nums[key % size].next;
            }else {
                LinkNode node = nums[key % size];
                LinkNode p = node.next;
                while (p != null && p.val != key) {
                    node = node.next;
                    p = p.next;
                }
                if (p != null) {
                    node.next = p.next;
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (nums[key % size] != null) {
            LinkNode node = nums[key % size];
            while (node != null) {
                if (node.val == key) {
                    return true;
                } else {
                    node = node.next;
                }
            }
        }
        return false;
    }

    class LinkNode {
        public int val;
        public LinkNode next;

        public LinkNode() {}

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 解答成功:
 * 		执行耗时:55 ms,击败了12.67% 的Java用户
 * 		内存消耗:44.7 MB,击败了87.76% 的Java用户
 */
}