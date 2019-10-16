package hot;

import java.util.LinkedList;

import java.util.List;

public class Task438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < ss.length; i++) {
            int j;
            for (j = 0; i + j < ss.length && j < pp.length; j++) {
                if (ss[i + j] != pp[j]) {
                    break;
                }
            }
            if (j == pp.length) {
                list.add(i);
            }
        }
        return list;
    }
}
