package algorithm_sort;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length / 2; i >= 0; i--) { // 建堆
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) { // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大根堆
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapify(arr, 0, i); // 交换之后，需要重新检查堆是否符合大根堆，不符合则要调整
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left;  // 在左右孩子中选取较大的一个
            if (left + 1 < size && arr[left + 1] > arr[largest]) {
                largest = left + 1;
            }
            if (arr[index] > arr[largest]) { // 如果当前子树符合大根堆，则不需要再调整
                break;
            }
            swap(arr, index, largest);  // 与较大的一个孩子交换，继续向下调整
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean compare(int[] arr, int[] arr2) {
        if (arr.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            int[] arr = generateRandomArray(100, 100);
            int[] arr2 = arr.clone();
            Arrays.sort(arr2);
            heapSort(arr);
            if (!compare(arr2, arr)) {
                printArray(arr);
                printArray(arr2);
            }
        }
    }
}
