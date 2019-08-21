package algorithm_linked_list;

public class SmallerEqualBigger {
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

    }

    public static Node listPartition(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        Node[] arr = new Node[len];
        cur = head;
        int j = 0;
        while (cur != null) {
            arr[j++] = cur;
            cur = cur.next;
        }
        int less = -1;
        int more = len;
        int index = 0;
        while (index < more) {
            if (arr[index].value < k) {
                swap(arr, index++, ++less);
            } else if (arr[index].value > k) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        head = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i].next = arr[i + 1];
        }
        arr[arr.length - 1].next = null;
        return head;
    }


    public static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static Node listPartition2(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node lessStart = null;
        Node lessEnd = null;
        Node moreStart = null;
        Node moreEnd = null;
        Node equalStart = null;
        Node equalEnd = null;
        Node cur = head;
        while (cur != null) {
            if (cur.value < k) {
                if (lessEnd != null) {
                    lessEnd.next = cur;
                    lessEnd = lessEnd.next;
                } else {
                    lessStart = cur;
                    lessEnd = cur;
                }
            } else if (cur.value > k) {
                if (moreEnd != null) {
                    moreEnd.next = cur;
                    moreEnd = moreEnd.next;
                } else {
                    moreStart = cur;
                    moreEnd = cur;
                }
            } else {
                if (equalEnd != null) {
                    equalEnd.next = cur;
                    equalEnd = equalEnd.next;
                } else {
                    equalStart = cur;
                    equalEnd = cur;
                }
            }
            cur = cur.next;
        }
        head = null;
        Node tail = null;
        if (lessEnd != null) {
            head = lessStart;
            tail = lessEnd;
        }
        if (equalEnd != null) {
            if (tail != null) {
                tail.next = equalStart;
                tail = equalEnd;
            } else {
                head = equalStart;
                tail = equalEnd;
            }
        }
        if (moreEnd != null) {
            if (tail != null) {
                tail.next = moreStart;
                tail = moreEnd;
            } else {
                head = moreStart;
                tail = moreEnd;
            }
        }
        tail.next = null;
        return head;

    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = listPartition(head1, 5);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
