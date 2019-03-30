package algorithm_hash_map;

import javax.sound.sampled.Mixer;
import java.rmi.MarshalException;

public class Island {
    public static int countIslands(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                    infect(matrix, i, j, row, col);
                }
            }
        }
        return res;

    }

    public static void infect(int[][] matrix, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j] = 2;
        infect(matrix, i + 1, j, row, col);
        infect(matrix, i - 1, j, row, col);
        infect(matrix, i, j + 1, row, col);
        infect(matrix, i, j - 1, row, col);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }

}
