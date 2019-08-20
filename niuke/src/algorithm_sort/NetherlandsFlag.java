package algorithm_sort;

public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = generateArray();
        printArray(arr);
        partition(arr, 0, arr.length - 1, 1);
        printArray(arr);
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int index = l;
        while (index < more) {
            if (arr[index] < p) {
                swap(arr, index++, ++less);
            } else if (arr[index] > p) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
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
