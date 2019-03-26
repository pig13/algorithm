package algorithm_binary_tree;

public class PaperFolding {

    public static void printAllFolding(int N) {
        printAllFolding(1, N, true);
    }

    public static void printAllFolding(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printAllFolding(i + 1, N, true);
        System.out.println(down ? "down" : "up");
        printAllFolding(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolding(N);
    }

}
