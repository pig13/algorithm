package advanced_03;

import javax.swing.text.html.HTML;
import java.util.HashMap;

public class LRU {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> last;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K, V> node) {
            if (node == null) {
                return;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            }
        }

        public Node<K, V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<K, V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;

            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }

        public void moveNodeToTail(Node<K, V> node) {
            // 链表中必须存在
            if (this.tail == node) {
                return;
            }
            // 先把node分离出去
            if (this.head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

    }


    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> map;
        private NodeDoubleLinkedList<K, V> nodeList;
        private int capacity;

        MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
        }

        public V get(K key) {
            if (this.map.containsKey(key)) {
                Node<K, V> res = this.map.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (this.map.containsKey(key)) {
                Node<K, V> node = this.map.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else {
                Node<K, V> node = new Node<>(key, value);
                this.nodeList.addNode(node);
                this.map.put(key, node);
                if (this.map.size() == this.capacity + 1) {
                    Node<K, V> removeNode = this.nodeList.removeHead();
                    this.map.remove(removeNode.key);
                }

            }
        }

    }

    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }
}
