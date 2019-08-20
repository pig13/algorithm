package advanced_02;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap();
        treeMap.put(5, "tom");
        treeMap.put(11, "jack");
        treeMap.put(30, "tony");
        treeMap.put(18, "alice");
        treeMap.put(25, "jerry");


        //红黑树中最右边的结点
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.lastKey());
        //红黑树最左边的结点
        System.out.println(treeMap.firstKey());
        //如果有13这个key，那么返回这条记录，否则返回树中比13大的key中最小的那一个
        System.out.println(treeMap.ceilingEntry(13));
        //如果有21这个key，那么返回这条记录，否则返回树中比21小的key中最大的那一个
        System.out.println(treeMap.floorEntry(21));
        //比11大的key中，最小的那一个
        System.out.println(treeMap.higherKey(11));
        //比25小的key中，最大的那一个
        System.out.println(treeMap.lowerKey(25));
        //遍历红黑树，是按key有序遍历的
        for (Map.Entry<Integer, String> record : treeMap.entrySet()) {
            System.out.println("age:" + record.getKey() + ",name:" + record.getValue());
        }

    }
}
