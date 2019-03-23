package algorithm_array;

public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(matrix[tR][curC++] + " ");
            }
            while (curR != dC) {
                System.out.print(matrix[curR++][dC] + " ");
            }
            while (curC != tC) {
                System.out.print(matrix[dR][curC--] + " ");
            }
            while (curR != tR) {
                System.out.print(matrix[curR--][tR] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }
}
