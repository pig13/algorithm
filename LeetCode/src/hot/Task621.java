package hot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Task621 {

    public static class Node {
        char value;
        int times;

        Node(char value, int times) {
            this.value = value;
            this.times = times;
        }
    }

    public static class NodeCompare implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.times - o1.times;
        }
    }

    // 暴力全模拟
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeCompare());
        PriorityQueue<Node> help = new PriorityQueue<>(new NodeCompare());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.add(node);
        }
        int ans = 0;
        int cur = -1;
        while (!queue.isEmpty() && queue.peek().times != 0) {

            while (!queue.isEmpty() && queue.peek().times != 0) {
                queue.peek().times--;
                help.add(queue.poll());
                cur++;
                ans++;
                if (cur >= n) {
                    break;
                }
            }
            while (!queue.isEmpty()) {
                help.add(queue.poll());
            }
            if (help.peek().times == 0) {
                break;
            }
            ans += cur >= n ? 0 : n - cur;
            cur = -1;
            PriorityQueue<Node> tmp = queue;
            queue = help;
            help = tmp;
        }
        return ans;
    }

    // 总结规律，直接搞
    public int leastInterval2(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        int ch[] = new int[256];
        // 统计字母出现的频率
        for (char c : tasks) {
            ch[c]++;
        }
        //<!-- 获取出现最多的次数 -->
        int max = Integer.MIN_VALUE;
        for (int i : ch) {
            max = Math.max(max, i);
        }
        //<!-- 得到一共有几个字母都以最高频次出现 -->
        int count = 0;
        for (int i : ch) {
            if (i == max) ++count;
        }
        return Math.max((n + 1) * (max - 1) + count, tasks.length);
    }


}
