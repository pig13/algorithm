import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class test {

    public static class Node {
        String name;
        int score;
        int pun;
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else {
                return o1.pun - o2.pun;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> arr = new ArrayList<Node>(n);
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            Node node = new Node();
            node.name = tmp[0];
            node.score = Integer.valueOf(tmp[1]);
            node.pun = Integer.valueOf(tmp[2]);
            arr.add(node);
        }
        arr.sort(new NodeComparator());
        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i).name);
        }
    }

}