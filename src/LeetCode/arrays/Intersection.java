package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        ArrayList<Integer> retArray = new ArrayList<>();

        Iterator<Integer> iterator = l1.iterator();
        while (iterator.hasNext()) {
            Integer element1 = iterator.next();
            if (l2.contains(element1)) {
                l2.remove(element1);
                retArray.add(element1);
            }
        }


        int[] ints = new int[retArray.size()];
        for (int i = 0; i < retArray.size(); i++) {
            ints[i] = retArray.get(i);
        }
        return ints;
    }
}
