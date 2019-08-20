package advanced_01;

import java.util.Stack;

public class Pair {
    /* 烽火相望问题 */
    public static class Record {
        int value;
        int times;

        public Record(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static int comunications(int[] arr) {
        // index of first max process
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex]));
        int res = 0;
        int index = nextIndex(arr, maxIndex);
        while (index != maxIndex) {
            while (!stack.empty() && arr[index] > stack.peek().value) {
                Record record = stack.pop();
                res += getInternalPairs(record.times) + record.times * 2;
            }
            if (arr[index] == stack.peek().value) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(arr, index);
        }
        while (!stack.empty()) {
            Record record = stack.pop();
            res += getInternalPairs(record.times);
            if (!stack.empty()) {
                res += record.times;
                if (stack.size() > 1) {
                    res += record.times;
                } else {
                    res += stack.peek().times > 1 ? record.times : 0;
                }
            }
        }
        return res;
    }

    //C(times,2)
    public static int getInternalPairs(int times) {
        return (times * (times - 1)) / 2;
    }

    public static int nextIndex(int[] arr, int index) {
        return index < arr.length - 1 ? index + 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 4, 4, 4, 9, 1};
        System.out.println(comunications(arr))

        ;
    }
}
