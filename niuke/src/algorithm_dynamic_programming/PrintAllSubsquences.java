package algorithm_dynamic_programming;

public class PrintAllSubsquences {


    public static void printAllsubsquence2(char[] chs, int i) {
        if (chs.length == i) {
            System.out.println(String.valueOf(chs));
            return;
        }
        printAllsubsquence2(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        printAllsubsquence2(chs, i + 1);
        chs[i] = tmp;
    }


    public static void main(String[] args) {
        printAllsubsquence2("asd".toCharArray(),0);
    }
}
