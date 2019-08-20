package algorithm_array;

public class PrintMatrixSpiralOrder {
    public static void printRingMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            printEdge(matrix, row1++, col1++, row2--, col2--);
        }
    }


    public static void printEdge(int[][] arr, int row1, int col1, int row2, int col2) {
        int row = row1;
        int col = col1;
        if (row1 == row2) {
            while (col <= col2) {
                System.out.print(arr[row][col++] + ",");
            }
        } else if (col1 == col2) {
            while (row <= row2) {
                System.out.print(arr[row++][col] + ",");
            }
        } else {
            while (col < col2) {
                System.out.print(arr[row][col++] + ",");
            }
            while (row < row2) {
                System.out.print(arr[row++][col] + ",");
            }
            while (col > col1) {
                System.out.print(arr[row][col--] + ",");
            }
            while (row > row1) {
                System.out.print(arr[row--][col] + ",");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printRingMatrix(matrix);

    }
}
