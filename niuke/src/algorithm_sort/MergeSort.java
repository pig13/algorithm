package algorithm_sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = generateRandomArray(100, 1233);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2; // 防止 (left + right)/2 中 left+right 溢出
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int cur = 0;
        while (p1 <= mid && p2 <= right) {
            help[cur++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[cur++] = arr[p1++];
        }
        while (p2 <= right) {
            help[cur++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

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
