package algorithm_dynamic_programming;

public class MInPath {

    public static int minPath1(int[][] matrix) {
        return process1(matrix, 0, 0);
    }

    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == matrix.length - 1 && matrix[0].length - 1 == j) {
            return res;
        }
        if (j == matrix[0].length - 1) {
            return res + process1(matrix, i + 1, j);
        } else if (i == matrix.length - 1) {
            return res + process1(matrix, i, j + 1);
        } else {
            return res + Math.min(process1(matrix, i, j + 1), process1(matrix, i + 1, j));
        }
    }

    public static int minPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        // 从左下角往上推
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 把右下点确认
        dp[row][col] = matrix[row][col];
        // 把最后一列确认
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = matrix[i][col] + dp[i + 1][col];
        }
        // 把最后一行确认
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = matrix[row][i] + dp[row][i + 1];
        }

        // 其次推其他点
        for (int i = row - 1; i >= 0; i--) {
            // i 代表当前行数
            // 一行一行的推
            for (int j = col - 1; j >= 0; j--) {
                // j 代表当前列数
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));


    }

}
