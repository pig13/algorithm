package day01;

import com.sun.org.apache.regexp.internal.RE;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(1000, 1000);
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, right, left + (int) (Math.random() * (right - left +  1)));
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }


    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int index = left;
        while (index < more) {
            if (arr[index] < arr[right]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[right]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
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

}
