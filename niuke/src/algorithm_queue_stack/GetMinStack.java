package algorithm_queue_stack;

import java.util.Stack;

public class GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int obj) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(obj);
            } else if (this.getMin() >= obj) {
                this.stackMin.push(obj);
            }
            this.stackData.push(obj);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }


    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int obj) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(obj);
            } else if (this.getMin() >= obj) {
                this.stackMin.push(obj);
            } else {
                this.stackMin.push(this.getMin());
            }
            this.stackData.push(obj);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }


    }

    public static void main(String[] args) {
        MyStack2 stack1 = new MyStack2();
        stack1.push(11);
        stack1.push(13);
        stack1.push(14);
        stack1.push(19);
        stack1.push(9);
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
    }
}
