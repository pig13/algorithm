package algorithm_queue_stack;

public class ArrayToStackQueue {


    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("This init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("This stack is empty");
            }
            return arr[--size];
        }

        public void push(int obj) {
            if (size >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("This stack is full");
            }
            arr[size++] = obj;
        }

    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("This init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (arr.length == 0) {
                return null;
            }
            return arr[first];
        }

        public Integer poll() {
            if (arr.length == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }

        public void push(int obj) {
            if (arr.length == size) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = arr.length - 1 == last ? 0 : last + 1;
        }


    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(123);
        stack.push(234);
        stack.push(456);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
