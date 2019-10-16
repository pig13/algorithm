package hot;

import java.util.HashSet;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1222);
        Object[] arr = set.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }


    }

}
