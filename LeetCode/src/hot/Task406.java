package hot;

import java.util.Arrays;
import java.util.Comparator;

public class Task406 {


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        for (int i = 0; i < people.length; i++) {
            int times = i - people[i][1];
            for (int j = 0; j < times; j++) {
                swap(people, i - j, i - j - 1);
            }
        }
        return people;
    }

    public static void swap(int[][] arr, int i, int j) {
        int tmp = arr[i][0];
        int tmp2 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tmp;
        arr[j][1] = tmp2;
    }


}
