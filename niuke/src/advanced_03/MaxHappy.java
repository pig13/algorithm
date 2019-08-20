package advanced_03;

import java.util.LinkedList;

public class MaxHappy {
    public static class Data {
        int activityIncludeHead;
        int activity;

        public Data(int activity, int activityIncludeHead) {
            this.activity = activity;
            this.activityIncludeHead = activityIncludeHead;
        }
    }

    public static class Node {
        int value;
        LinkedList<Node> nexts;

        public Node(int value) {
            this.value = value;
            this.nexts = null;
        }

    }

    public static int maxHappy(Node head) {
        Data data = process(head);
        return Math.max(data.activity, data.activityIncludeHead);
    }

    public static Data process(Node head) {
        if (head == null) {
            return new Data(0, 0);
        }
        int activity = 0;
        int activityIncludeHead = head.value;
        for (Node cur : head.nexts) {
            Data curData = process(cur);
            activityIncludeHead += activity;
            activity += Math.max(curData.activity, curData.activityIncludeHead);
        }
        return new Data(activity, activityIncludeHead);


    }

}
