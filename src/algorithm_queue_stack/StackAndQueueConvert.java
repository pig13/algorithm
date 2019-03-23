package algorithm_queue_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        public void push(int obj) {
            this.stackPush.push(obj);
        }

        public int poll() {
            if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
                throw new RuntimeException("your queue is empty!");
            } else if (this.stackPop.isEmpty()) {
                while (!this.stackPush.isEmpty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.pop();
        }

        public int peek() {
            if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
                throw new RuntimeException("your queue is empty!");
            } else if (this.stackPop.isEmpty()) {
                while (!this.stackPush.isEmpty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }
            return this.stackPop.peek();
        }


    }

    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<Integer>();
            this.help = new LinkedList<Integer>();
        }

        public void push(int obj) {
            queue.add(obj);
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;

        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = this.help;
            help = queue;
            queue = tmp;
        }

    }

    public static void main(String[] args) {
//        TwoStackQueue queue = new TwoStackQueue();
//        queue.push(1);
//        queue.push(2);
//        queue.push(34);
//        queue.push(333);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(34);
        stack.push(333);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());


    }

}
