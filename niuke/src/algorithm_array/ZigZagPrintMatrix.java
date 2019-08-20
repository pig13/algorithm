package algorithm_array;

public class ZigZagPrintMatrix {

    public static void ZigZagPrintMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        boolean isUp = true;
        while (col2 <= col) {
            ZigZagprint(matrix, row1, col1, row2, col2, isUp);
            isUp = !isUp;
            if (col1 < col) {
                col1++;
            } else {
                row1++;
            }
            if (row2 < row) {
                row2++;
            } else {
                col2++;
            }
        }
    }

    public static void ZigZagprint(int[][] matrix, int row1, int col1, int row2, int col2, boolean isUp) {
        if (isUp) {
            while (col2 != col1 + 1) {
                System.out.print(matrix[row2--][col2++] + " ");
            }
        } else {
            while (row1 != row2 + 1) {
                System.out.print(matrix[row1++][col1--] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        ZigZagPrintMatrix(matrix);
    }

}
