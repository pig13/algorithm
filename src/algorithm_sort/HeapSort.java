package algorithm_sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(1000, 100);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 从大根堆中抽取数据
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            largest = arr[largest] < arr[index] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
