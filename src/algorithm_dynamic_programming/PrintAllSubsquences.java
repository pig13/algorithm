package algorithm_dynamic_programming;

public class PrintAllSubsquences {
    public static void printAllsubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0; // 这个位置变成空白
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static void main(String[] args) {
        printAllsubsquence("asd");
    }
}
