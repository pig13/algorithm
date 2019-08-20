package advanced_02;

import java.util.ArrayList;
import java.util.Iterator;

public class SkipList_ {

    public static class SkipListNode {
        public Integer value;
        public ArrayList<SkipListNode> nextNodes;    // 10 ——》10层， nextNodes[n],在第n层，下一个是另一个节点 或者 null

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<SkipListNode>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer> {
        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list) {
            this.list = list;
            this.current = list.getHead();
        }

        public boolean hasNext() {
            return current.nextNodes.get(0) != null;
        }

        public Integer next() {
            current = current.nextNodes.get(0);
            return current.value;
        }
    }

    public static class SkipList {
        private SkipListNode head;    // 巨小，系统最小
        private int maxLevel;    // 最大层
        private int size;    //
        private static final double PROBABILITY = 0.5;    // 概率，以50%的概率产生0,以50%的概率产生1

        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(Integer newValue) {
            if (!contains(newValue)) {
                size++;
                int level = 0;
                while (Math.random() < PROBABILITY) { // 扔色子决定层数
                    level++;
                }
                while (level > maxLevel) { // 扩充原有层数
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode newNode = new SkipListNode(newValue);    // 新的值
                SkipListNode current = head;    // 从头开始找
                do {
                    // 核心代码
                    current = findNext(newValue, current, level); // 在level层一直向右找，直到下一个值比newValue大
                    newNode.nextNodes.add(0, current.nextNodes.get(level)); // newNode设置层，连接到下一个 SkipListNode
                    // 为什么 插入到0位置？
                    // newNode时从上向下的n~0层,从底部往上怼，从而形成  [0]->[n],[0,1]->[n,n-1],[0,1,2]->[n,n-1,n-2] ... [0,1,2...,n-1,n]->[n,n-1,n-2...1,0]
                    current.nextNodes.set(level, newNode);  // 当前SkipListNode的level层 连接到 newNode
                } while (level-- > 0);
            }
        }

        public void delete(Integer deleteValue) {
            if (contains(deleteValue)) {
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodes.size() > level) {
                        current.nextNodes.set(level, deleteNode.nextNodes.get(level));
                    }
                } while (level-- > 0);
            }
        }

        // Returns the skiplist node with greatest process <= e
        private SkipListNode find(Integer e) {
            return find(e, head, maxLevel);
        }

        // Returns the skiplist node with greatest process <= e
        // Starts at node start and level
        private SkipListNode find(Integer e, SkipListNode current, int level) {
            do {
                current = findNext(e, current, level);
            } while (level-- > 0);
            return current;
        }

        // Returns the node at a given level with highest process less than e
        private SkipListNode findNext(Integer e, SkipListNode current, int level) {
            SkipListNode next = current.nextNodes.get(level);  // 当前的第level的下一个节点
            while (next != null) {
                Integer value = next.value;
                if (lessThan(e, value)) { // e < value
                    // 下一个节点的比当前大，向下找
                    break;
                }
                // 下一个节点的比当前小，向右找
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        public int size() {
            return size;
        }

        public boolean contains(Integer value) {
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        public Iterator<Integer> iterator() {
            return new SkipListIterator(this);
        }

        /******************************************************************************
         * Utility Functions *
         ******************************************************************************/

        private boolean lessThan(Integer a, Integer b) {
            return a.compareTo(b) < 0;
        }

        private boolean equalTo(Integer a, Integer b) {
            return a.compareTo(b) == 0;
        }

    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.add(9);
        sl.add(3);
        sl.add(7);
        sl.add(6);
    }

}
